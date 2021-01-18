package person.liufan.bookstore.servlet;

import org.springframework.web.context.WebApplicationContext;
import person.liufan.bookstore.entity.BookstoreUser;
import person.liufan.bookstore.service.UserService;
import person.liufan.bookstore.util.MyPrintOut;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 处理注册相关请求的servlet，前端校验成功将数据保存到数据库
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String attr = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        WebApplicationContext ac = (WebApplicationContext) this.getServletContext().getAttribute(attr);
        UserService userService = (UserService) ac.getBean("userServiceImpl");
        Boolean flag = userService.sava(new BookstoreUser());
        MyPrintOut.printJson(response,flag);
    }

}
