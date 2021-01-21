package person.liufan.bookstore.servlet;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import person.liufan.bookstore.constant.MyConstant;
import person.liufan.bookstore.entity.*;
import person.liufan.bookstore.service.BookService;
import person.liufan.bookstore.service.OrderService;
import person.liufan.bookstore.service.OrderShoppingCartService;
import person.liufan.bookstore.service.ShoppingCartService;
import person.liufan.bookstore.util.MyPrintOut;
import person.liufan.bookstore.vo.BookDetaillVO;
import person.liufan.bookstore.vo.CartVO;
import person.liufan.bookstore.vo.OrderDetailVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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
        BookService bookService = (BookService) ac.getBean("bookServiceImpl");
        ShoppingCartService shoppingCartService = (ShoppingCartService) ac.getBean("shoppingCartServiceImpl");
        OrderShoppingCartService orderCartService = (OrderShoppingCartService) ac.getBean("orderShoppingCartServiceImpl");
        BookstoreUser user = (BookstoreUser) request.getSession().getAttribute("user");
        Long userId = user.getId();
        String type = request.getParameter(MyConstant.TYPE);
        //保存订单
        if (MyConstant.TYPE_SAVE.equals(type)) {
            String param = request.getParameter("orderCartList");
            String[] ids = param.split("&");
            BookstoreOrder order = toOrder(request, userId);
            Boolean flag = orderService.sava(ids,order);
            MyPrintOut.printJson(response, flag);
        }
        //查询所有订单，使用分页
        if (MyConstant.TYPE_QUERY_DETAIL.equals(type)) {
            //获取查询条件
            String orderId = request.getParameter(MyConstant.PARAMETER_ID);
            Long id = null;
            if (orderId != null && orderId != "") {
                id = Long.valueOf(orderId);
            }
            int pageNum = Integer.parseInt(request.getParameter("pageNum"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            //查询
            PageInfo<BookstoreOrder> pageInfo = orderService.listOrderDetailById(id,userId,pageNum,pageSize);
            //包装查询结果
            Map map = new HashMap(8);
            List<BookstoreOrder> list = pageInfo.getList();
            Long count = pageInfo.getTotal();
            //将查询出来的所有订单转换为对应的voList
            List<OrderDetailVO> orderDetailVOS = toVOList(list, bookService, orderCartService);
            //返回查询结果
            map.put("count", count);
            map.put("data", orderDetailVOS);
            MyPrintOut.printJson(response, map);
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

    private List<OrderDetailVO> toVOList(List<BookstoreOrder> orders,
                                         BookService bookService,
                                         OrderShoppingCartService orderShoppingCartService) {
        List<OrderDetailVO> voList = new ArrayList<>(orders.size());
        for (BookstoreOrder order : orders) {
            OrderDetailVO vo = new OrderDetailVO();
            //将order中的订单号，总金额，下单时间，收货地址保存到vo
            vo.setId(order.getId());
            vo.setTbBookstoreOrderTotalMoney(order.getTbBookstoreOrderTotalMoney());
            vo.setTbBookstoreOrderShippingAddress(order.getTbBookstoreOrderShippingAddress());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            vo.setTbBookstoreOrderCreateTime(simpleDateFormat.format(order.getTbBookstoreOrderCreateTime()));

            //获取该订单号所有的cart详情
            List<BookstoreOrderShoppingCart> carts = orderShoppingCartService.listCartByOrderId(order.getId());
            List<CartVO> cartVOList = new ArrayList<>(carts.size());
            for (BookstoreOrderShoppingCart cart : carts) {
                CartVO cartVO = new CartVO();
                BookstoreBook book = bookService.selectById(cart.getTbBookstoreOrderTbscBookId());
                cartVO.setId(cart.getId());
                cartVO.setTbBookstoreBookName(book.getTbBookstoreBookName());
                cartVO.setTbBookstoreBookPrice(book.getTbBookstoreBookPrice());
                cartVO.setTbBookstoreShoppingCartBookCount(cart.getTbBookstoreOrderTbscBookCount());
                cartVOList.add(cartVO);
            }
            vo.setCartVOS(cartVOList);
            voList.add(vo);
        }
        return voList;
    }
}
