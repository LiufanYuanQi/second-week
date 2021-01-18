package person.liufan.bookstore.servlet;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import person.liufan.bookstore.constant.MyConstant;
import person.liufan.bookstore.entity.City;
import person.liufan.bookstore.entity.Province;
import person.liufan.bookstore.service.CityService;
import person.liufan.bookstore.service.ProvinceService;
import person.liufan.bookstore.util.MyPrintOut;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/12
 *
 * 用于处理获取省份城市ajax请求的servlet
 *
 */
@Component
@WebServlet(name = "provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String attr = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        WebApplicationContext ac = (WebApplicationContext) this.getServletContext().getAttribute(attr);
        String type = request.getParameter(MyConstant.TYPE);
        /**
         * 返回所有省份
         */
        if (MyConstant.TYPE_PROVINCE.equals(type)) {
            ProvinceService provinceService = (ProvinceService) ac.getBean("provinceServiceImpl");
            List<Province> list = provinceService.listProvince();
            MyPrintOut.printJson(response,list);
        }
        /**
         * 返回指定身份的所有的城市
         */
        if (MyConstant.TYPE_CITY.equals(type)) {
            CityService cityService = (CityService) ac.getBean("cityServiceImpl");
            Long provinceId = Long.valueOf(request.getParameter("provinceId"));
            List<City> list = cityService.listCity(provinceId);
            MyPrintOut.printJson(response,list);
        }
    }
}
