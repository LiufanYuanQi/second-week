package person.liufan.bookstore.servlet;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import person.liufan.bookstore.constant.MyConstant;
import person.liufan.bookstore.entity.BookstoreOrder;
import person.liufan.bookstore.entity.BookstoreUser;
import person.liufan.bookstore.service.OrderService;
import person.liufan.bookstore.util.MyPrintOut;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 对Order页面的请求响应
 * queryOrderById:显示该用户的所有订单
 *
 */
@Component
@WebServlet(name = "orderServlet")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String attr = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        WebApplicationContext ac = (WebApplicationContext) this.getServletContext().getAttribute(attr);
        OrderService orderService = (OrderService) ac.getBean("orderServiceImpl");
        BookstoreUser user = (BookstoreUser) request.getSession().getAttribute("user");
        Long userId = user.getId();
        String type = request.getParameter(MyConstant.TYPE);
        if (MyConstant.TYPE_SAVE.equals(type)) {
            String param = request.getParameter("orderCartList");
            String[] ids = param.split("&");
            BookstoreOrder order = toOrder(request, userId);
            Boolean flag = orderService.sava(ids,order);
            MyPrintOut.printJson(response, flag);
        }
    }

    private BookstoreOrder toOrder(HttpServletRequest request,Long userId) {
        BookstoreOrder order = new BookstoreOrder();
        String orderTotalMoney = request.getParameter("orderTotalMoney");
        String orderAddress = request.getParameter("orderAddress");
        BigDecimal bigDecimal = new BigDecimal(orderTotalMoney);
        order.setTbBookstoreOrderTotalMoney(bigDecimal);
        order.setTbBookstoreOrderShippingAddress(orderAddress);
        order.setTbBookstoreOrderCreateTime(new Date());
        order.setTbBookstoreOrderUserId(userId);
        return order;
    }
}
