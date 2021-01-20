package person.liufan.bookstore.service.impl;

import org.springframework.stereotype.Component;
import person.liufan.bookstore.entity.*;
import person.liufan.bookstore.mapper.*;
import person.liufan.bookstore.service.OrderService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/20
 */
@Component
public class OrderServiceImpl implements OrderService {
    @Resource
    private BookstoreOrderMapper orderMapper;
    @Resource
    private BookstoreOrderShoppingCartMapper orderShoppingCartMapper;
    @Resource
    private BookstoreShoppingCartMapper shoppingCartMapper;
    @Resource
    private OrderBookMapper orderBookMapper;
    @Resource
    private BookstoreBookMapper bookMapper;

    /**
     * 将order订单保存，使用随机数生成订单号，当订单表订单号唯一时，保存
     * 将ids对应的cart的信息保存到order_tbsc中，然后将这个订单号移除cart，然后将每个cart中的书籍信息持久化到order_book中
     * @param ids 购物车中记录的id
     * @param order 订单信息
     * @return 操作结果
     */
    @Override
    public Boolean sava(String[] ids, BookstoreOrder order) {
        //创建一个唯一随机的id，将订单保存
        Random random = new Random();
        Long randomLong = random.nextLong();
        while (true) {
            BookstoreOrder bookstoreOrder = orderMapper.selectByPrimaryKey(randomLong);
            if (bookstoreOrder != null) {
                randomLong = random.nextLong();
            } else {
                break;
            }
        }
        order.setId(randomLong);
        orderMapper.insertSelective(order);

        for (int i = 0; i < ids.length; i++) {
            //将ids的信息保存到order_tbsc中
            BookstoreShoppingCart shoppingCart = shoppingCartMapper.selectByPrimaryKey(Long.valueOf(ids[i]));
            BookstoreOrderShoppingCart orderShoppingCart = new BookstoreOrderShoppingCart();
            orderShoppingCart.setTbBookstoreOrderTbscOrderId(randomLong);
            orderShoppingCart.setTbBookstoreOrderTbscBookId(shoppingCart.getTbBookstoreShoppingCartBookId());
            orderShoppingCart.setTbBookstoreOrderTbscBookCount(shoppingCart.getTbBookstoreShoppingCartBookCount());
            orderShoppingCart.setTbBookstoreOrderTbscCreateTime(new Date());
            orderShoppingCartMapper.insertSelective(orderShoppingCart);
            //将cart中的书籍信息持久化到order_book
            Long bookId = shoppingCart.getTbBookstoreShoppingCartBookId();
            BookstoreBook book = bookMapper.selectByPrimaryKey(bookId);
            OrderBook orderBook = toOrderBook(book);
            orderBookMapper.insertSelective(orderBook);
            //删除出当前购物车中id为当前值得记录
            shoppingCartMapper.deleteByPrimaryKey(Long.valueOf(ids[i]));
        }

        return null;
    }

    private OrderBook toOrderBook(BookstoreBook book) {
        OrderBook orderBook = new OrderBook();
        orderBook.setTbBookstoreBookName(book.getTbBookstoreBookName());
        orderBook.setTbBookstoreBookAuthor(book.getTbBookstoreBookAuthor());
        orderBook.setTbBookstoreBookPublishing(book.getTbBookstoreBookPublishing());
        orderBook.setTbBookstoreBookPrice(book.getTbBookstoreBookPrice());
        orderBook.setTbBookstoreBookNumber(book.getTbBookstoreBookNumber());
        orderBook.setTbBookstoreBookInfo(book.getTbBookstoreBookInfo());
        orderBook.setTbBookstoreBookCreateTime(new Date());
        return orderBook;
    }
}
