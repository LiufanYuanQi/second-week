package person.liufan.bookstore.service;

import person.liufan.bookstore.entity.BookstoreUser;

import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 */
public interface UserService {
    /**
     * 对登录操作上传的用户进行验证
     * @param userName 用户名
     * @param password 密码
     * @return 失败返回flag=false，和message=错误原因
     *          成功返回true，和查询到的用户
     */
    Map login(String userName, String password);

    Boolean sava(BookstoreUser user);
}
