package person.liufan.bookstore.service;

import com.github.pagehelper.PageInfo;
import person.liufan.bookstore.entity.BookstoreOrder;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/20
 */
public interface OrderService {
    /**
     * 将order订单保存，使用随机数生成订单号，当订单表订单号唯一时，保存
     * 将ids对应的cart的信息保存到order_tbsc中，然后将这个订单号移除cart，然后将每个cart中的书籍信息持久化到order_book中
     * @param ids 购物车中记录的id
     * @param order 订单信息
     * @return 操作结果
     */
    Boolean sava(String[] ids, BookstoreOrder order);

    /**
     * 通过用户id，默认查询的id值查询所有的订单，
     * @param id id
     * @param userId 用户订单
     * @param pageNum 页码
     * @param pageSize 大小
     * @return 查询结果
     */
    PageInfo<BookstoreOrder> listOrderDetailById(Long id, Long userId, int pageNum, int pageSize);
}
