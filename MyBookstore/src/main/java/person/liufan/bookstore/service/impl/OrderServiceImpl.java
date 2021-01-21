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
     * 将ids对应的cart的信息保存到order_tbsc中，
     * 然后将每个cart中的书籍信息持久化到order_book中，
     * 更新库存，
     * 然后将这个订单号移除cart，
     *
     *
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
            //获取当前id的购物车记录
            BookstoreShoppingCart shoppingCart = shoppingCartMapper.selectByPrimaryKey(Long.valueOf(ids[i]));
            //创建订单关系表，并保持
            BookstoreOrderShoppingCart orderShoppingCart = new BookstoreOrderShoppingCart();
            orderShoppingCart.setTbBookstoreOrderTbscOrderId(randomLong);
            orderShoppingCart.setTbBookstoreOrderTbscBookId(shoppingCart.getTbBookstoreShoppingCartBookId());
            orderShoppingCart.setTbBookstoreOrderTbscBookCount(shoppingCart.getTbBookstoreShoppingCartBookCount());
            orderShoppingCart.setTbBookstoreOrderTbscCreateTime(new Date());
            orderShoppingCartMapper.insertSelective(orderShoppingCart);

            //获取book数据
            Long bookId = shoppingCart.getTbBookstoreShoppingCartBookId();
            BookstoreBook book = bookMapper.selectByPrimaryKey(bookId);
            //如果书籍信息不存在，将cart中的书籍信息持久化到order_book
            OrderBook orderBook = toOrderBook(book);
            OrderBook rest = orderBookMapper.selectByPrimaryKey(orderBook.getId());
            if (rest == null) {
                orderBookMapper.insertSelective(orderBook);
            }
            //当前购买的数量
            Integer count = shoppingCart.getTbBookstoreShoppingCartBookCount();
            //当前书本的库存
            Integer number = book.getTbBookstoreBookNumber();
            //更新书本的库存
            book.setTbBookstoreBookNumber(number - count);
            //保存数据
            bookMapper.updateByPrimaryKey(book);
            //删除出当前购物车中id为当前值得记录
            shoppingCartMapper.deleteByPrimaryKey(Long.valueOf(ids[i]));
        }
        return null;
    }

    private OrderBook toOrderBook(BookstoreBook book) {
        OrderBook orderBook = new OrderBook();
        orderBook.setId(book.getId());
        orderBook.setTbBookstoreBookName(book.getTbBookstoreBookName());
        orderBook.setTbBookstoreBookPictureUrl(book.getTbBookstoreBookPictureUrl());
        orderBook.setTbBookstoreBookAuthor(book.getTbBookstoreBookAuthor());
        orderBook.setTbBookstoreBookPublishing(book.getTbBookstoreBookPublishing());
        orderBook.setTbBookstoreBookPrice(book.getTbBookstoreBookPrice());
        orderBook.setTbBookstoreBookNumber(book.getTbBookstoreBookNumber());
        orderBook.setTbBookstoreBookInfo(book.getTbBookstoreBookInfo());
        orderBook.setTbBookstoreBookCreateTime(new Date());
        return orderBook;
    }
}
