package person.liufan.bookstore.servlet;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import person.liufan.bookstore.constant.MyConstant;
import person.liufan.bookstore.entity.BookstoreUser;
import person.liufan.bookstore.service.UserService;
import person.liufan.bookstore.util.MyPrintOut;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 处理注册相关请求的servlet，前端校验成功将数据保存到数据库
 */
@Component
@WebServlet(name = "registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String attr = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        WebApplicationContext ac = (WebApplicationContext) this.getServletContext().getAttribute(attr);
        UserService userService = (UserService) ac.getBean("userServiceImpl");
        Boolean flag = userService.sava(toUser(request));
        MyPrintOut.printJson(response,flag);
    }

    private BookstoreUser toUser(HttpServletRequest request) {
        String name =request.getParameter(MyConstant.PARAMETER_NAME);
        String password =request.getParameter(MyConstant.PARAMETER_PASSWORD);
        String realName =request.getParameter(MyConstant.PARAMETER_REAL_NAME);
        String phone =request.getParameter(MyConstant.PARAMETER_PHONE);
        String email =request.getParameter(MyConstant.PARAMETER_EMAIL);
        String cityId =request.getParameter(MyConstant.PARAMETER_CITY_ID);
        String address =request.getParameter(MyConstant.PARAMETER_ADDRESS);
        String hobbies =request.getParameter(MyConstant.PARAMETER_HOBBIES);

        BookstoreUser user = new BookstoreUser();
        user.setTbBookstoreUserName(name);
        user.setTbBookstoreUserPassword(password);
        user.setTbBookstoreUserRealName(realName);
        user.setTbBookstoreUserPhone(phone);
        user.setTbBookstoreUserEmail(email);
        user.setTbBookstoreUserCityId(Long.valueOf(cityId));
        user.setTbBookstoreUserAddress(address);
        user.setTbBookstoreUserHobby(hobbies);
        user.setTbBookstoreUserCreateTime(new Date());
        return user;
    }

}
