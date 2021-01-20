package person.liufan.bookstore.servlet;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import person.liufan.bookstore.constant.MyConstant;
import person.liufan.bookstore.entity.BookstoreBook;
import person.liufan.bookstore.entity.BookstoreShoppingCart;
import person.liufan.bookstore.entity.BookstoreUser;
import person.liufan.bookstore.service.BookService;
import person.liufan.bookstore.service.ShoppingCartService;
import person.liufan.bookstore.util.MyPrintOut;
import person.liufan.bookstore.vo.BookDetaillVO;
import person.liufan.bookstore.vo.CartVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 对购物车的相关请求进行响应的servlet
 * 根据不同的type进行处理
 * getAllBook：获取所有在购物车中的记录
 * commitOrder：提交订单保存订单信息，清空购物车
 */
@Component
@WebServlet(name = "shoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String attr = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        WebApplicationContext ac = (WebApplicationContext) this.getServletContext().getAttribute(attr);
        BookService bookService = (BookService) ac.getBean("bookServiceImpl");
        ShoppingCartService shoppingCartService = (ShoppingCartService) ac.getBean("shoppingCartServiceImpl");
        BookstoreUser user = (BookstoreUser) request.getSession().getAttribute("user");
        Long userId = user.getId();
        String type = request.getParameter(MyConstant.TYPE);
        /**
         * 处理批量将书本添加到购物车的请求，前端将批量发送添加的书本ids，
         * 后端获取当前登录的用户id，将两者映射保存到购物车中，购买数量默认设置为1
         * 首先进行查询，当不存在时进行添加
         * 当部分保存时候返回结果，flag为true，并提示message
         * 当全部保存失败时，返回结果为false，并提示消息
         */
        if (MyConstant.TYPE_ADD_TO_SHOPPING_CART.equals(type)) {
            String param = request.getParameter("addList");
            String[] ids = param.split("&");
            Map rest = shoppingCartService.addToCartByBookId(ids,userId);
            MyPrintOut.printJson(response, rest);
        }
        /**
         * 处理保存请求，将前端发送的书本id，数量，和后端获取的用户id进行绑定
         * 保存到数据库中
         * 首先进行查询，如果不存在则添加，存在返回false
         */
        if (MyConstant.TYPE_SAVE.equals(type)) {
            BookstoreShoppingCart cart = toCart(request);
            cart.setTbBookstoreShoppingCartCreateTime(new Date());
            cart.setTbBookstoreShoppingCartUserId(userId);
            Boolean flag = shoppingCartService.sava(cart);
            MyPrintOut.printJson(response,flag);
        }
        /**
         * 通过id查询购物车记录，将查询结果返回给前端，用于页面渲染，需要返回查询到的书籍结果
         */
        if (MyConstant.TYPE_QUERY_BY_ID.equals(type)) {
            BookstoreShoppingCart cart = shoppingCartService.selectById(Long.valueOf(request.getParameter(MyConstant.PARAMETER_ID)));
            BookstoreBook book = bookService.selectById(cart.getTbBookstoreShoppingCartBookId());
            Map map = new HashMap(4);
            map.put("cart", cart);
            map.put("book", book);
            MyPrintOut.printJson(response,map);
        }
        /**
         * 将前端发送过来的的更改信息进行保存，通过id
         */
        if (MyConstant.TYPE_UPDATE.equals(type)) {
            BookstoreShoppingCart cart = toCart(request);
            cart.setId(Long.valueOf(request.getParameter("bookId")));
            cart.setTbBookstoreShoppingCartUpdateTime(new Date());
            boolean flag = shoppingCartService.updateById(cart);
            MyPrintOut.printJson(response, flag);
        }
        /**
         * 通过主键id批量删除购物车记录
         */
        if (MyConstant.TYPE_DELETE.equals(type)) {
            String param = request.getParameter("deleteList");
            String[] ids = param.split("&");
            Boolean flag = shoppingCartService.deleteCartByIds(ids);
            MyPrintOut.printJson(response, flag);
        }
        /**
         * 通过主键id返回书籍信息购物车信息，用于前端渲染页面
         * 发送的id为购物车中选中商品的id，
         * 首先获取这些id，获取出其对应的cartList合集
         * 然后进行遍历，当cart中的购买数量小于库存的时候，添加到list中，大于库存时，将name添加到messageList中，
         *
         */
        if (MyConstant.TYPE_GENERATE_ORDER.equals(type)) {
            String param = request.getParameter("shoppingCartList");
            String[] ids = param.split("&");
            Map map = shoppingCartService.createOrderByIds(ids);
            List<BookstoreShoppingCart> list = (List) map.get("cartList");
            List<CartVO> voList = toVOList(list, bookService);
            map.put("cartList", voList);
            MyPrintOut.printJson(response,map);
        }
        if (MyConstant.TYPE_QUERY_DETAIL.equals(type)) {
            String cartId = request.getParameter(MyConstant.PARAMETER_ID);
            Long id = null;
            if (cartId != null && cartId != "") {
                id = Long.valueOf(cartId);
            }
            int pageNum = Integer.parseInt(request.getParameter("pageNum"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            PageInfo<BookstoreShoppingCart> pageInfo = shoppingCartService.listCartDetailByName(id,userId,pageNum,pageSize);
            Map map = new HashMap(8);
            List<BookstoreShoppingCart> list = pageInfo.getList();
            Long count = pageInfo.getTotal();
            List<CartVO> voList = toVOList(list, bookService);
            map.put("count", count);
            map.put("data", voList);
            MyPrintOut.printJson(response, map);
        }

    }

    private BookstoreShoppingCart toCart(HttpServletRequest request) {
        BookstoreShoppingCart cart = new BookstoreShoppingCart();
        cart.setTbBookstoreShoppingCartBookId(Long.valueOf(request.getParameter("bookId")));
        cart.setTbBookstoreShoppingCartBookCount(Integer.valueOf(request.getParameter("bookCount")));
        return cart;
    }

    private List<CartVO> toVOList(List<BookstoreShoppingCart> list, BookService bookService) {
        List<CartVO> voList = new ArrayList<>(list.size());
        for (BookstoreShoppingCart cart : list) {
            CartVO vo = new CartVO();
            BookstoreBook book = bookService.selectById(cart.getTbBookstoreShoppingCartBookId());
            vo.setId(cart.getId());
            vo.setTbBookstoreBookName(book.getTbBookstoreBookName());
            vo.setTbBookstoreBookPrice(book.getTbBookstoreBookPrice());
            vo.setTbBookstoreShoppingCartBookCount(cart.getTbBookstoreShoppingCartBookCount());
            voList.add(vo);
        }
        return voList;
    }
}
