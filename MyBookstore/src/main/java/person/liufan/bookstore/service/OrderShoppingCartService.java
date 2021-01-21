package person.liufan.bookstore.service;

import person.liufan.bookstore.entity.BookstoreOrderShoppingCart;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/21
 */
public interface OrderShoppingCartService {
    /**
     * 通过订单号获取所有的对应详情
     * @param id 订单id
     * @return 查询结果
     */
    List<BookstoreOrderShoppingCart> listCartByOrderId(Long id);

}
