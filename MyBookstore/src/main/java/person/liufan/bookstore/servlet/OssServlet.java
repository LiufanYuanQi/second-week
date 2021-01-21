package person.liufan.bookstore.servlet;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import person.liufan.bookstore.util.MyPrintOut;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/21
 */
public class OssServlet extends HttpServlet {
    /**
     * alibaba.cloud.access-key=LTAI4GGHugD9cbKdzTgXEw6F
     * alibaba.cloud.secret-key=oC4qOOpnaDcnVaj6ZgfUpVzi3BzcqM
     * alibaba.cloud.oss.endpoint=oss-cn-chengdu.aliyuncs.com
     * alibaba.cloud.oss.bucket=gulimall-hello-yuanqi
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accessId = "LTAI4GGHugD9cbKdzTgXEw6F"; // 请填写您的AccessKeyId。
        String accessKey = "oC4qOOpnaDcnVaj6ZgfUpVzi3BzcqM"; // 请填写您的AccessKeySecret。
        String endpoint = "oss-cn-chengdu.aliyuncs.com"; // 请填写您的 endpoint。
        String bucket = "gulimall-hello-yuanqi"; // 请填写您的 bucketname 。
        // host的格式为 bucketname.endpoint
        String host = "https://" + bucket + "." + endpoint;
        // callbackUrl为 上传回调服务器的URL，请将下面的IP和Port配置为您自己的真实信息。
        /*String callbackUrl = "http://88.88.88.88:8888";*/
        String dir = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String key = dir;
        // 用户上传文件时指定的前缀。
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessId, accessKey);
        Map<String, String> respMap = new LinkedHashMap<String, String>();
        try {
            long expireTime = 300;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            // PostObject请求最大可支持的文件大小为5 GB，即CONTENT_LENGTH_RANGE为5*1024*1024*1024。
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);


            respMap.put("OSSAccessKeyId", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("key", key);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
            // respMap.put("expire", formatISO8601Date(expiration));



        } catch (Exception e) {
            // Assert.fail(e.getMessage());
            System.out.println(e.getMessage());

        } finally {
            ossClient.shutdown();
        }
        MyPrintOut.printJson(response, respMap);
    }



}
