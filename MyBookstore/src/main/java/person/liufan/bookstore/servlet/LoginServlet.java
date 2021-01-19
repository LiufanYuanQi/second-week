package person.liufan.bookstore.servlet;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import person.liufan.bookstore.constant.MyConstant;
import person.liufan.bookstore.service.UserService;
import person.liufan.bookstore.util.MyPrintOut;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 登录的servlet，路径为/login
 * 实现功能：对前端发送来的请求进行验证
 * 如果是管理员登录，验证成功，将用户信息放入session域中，然后跳转到后台管理页面
 * 如果是普通用户登录，验证成功，将用户信息放入session域中，然后跳转到购物首页
 */
@Component
@WebServlet(name = "loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String attr = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        WebApplicationContext ac = (WebApplicationContext) this.getServletContext().getAttribute(attr);
        UserService userService = (UserService) ac.getBean("userServiceImpl");

        String userName = request.getParameter(MyConstant.PARAMETER_NAME);
        String password = request.getParameter(MyConstant.PARAMETER_PASSWORD);
        Map map = userService.login(userName, password);
        if ((boolean)map.get(MyConstant.LOGIN_FLAG)) {
            HttpSession session = request.getSession();
            session.setAttribute(MyConstant.LOGIN_USER, map.get(MyConstant.LOGIN_USER));
            map.remove(MyConstant.LOGIN_USER);
        }
        MyPrintOut.printJson(response,map);
    }
}
