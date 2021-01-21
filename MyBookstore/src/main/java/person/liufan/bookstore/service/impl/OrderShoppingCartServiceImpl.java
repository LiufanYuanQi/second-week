package person.liufan.bookstore.service.impl;

import org.springframework.stereotype.Component;
import person.liufan.bookstore.entity.BookstoreOrderShoppingCart;
import person.liufan.bookstore.mapper.BookstoreOrderShoppingCartMapper;
import person.liufan.bookstore.service.OrderShoppingCartService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/21
 */
@Component
public class OrderShoppingCartServiceImpl implements OrderShoppingCartService {
    @Resource
    private BookstoreOrderShoppingCartMapper orderCartMapper;
    @Override
    public List<BookstoreOrderShoppingCart> listCartByOrderId(Long id) {
        List<BookstoreOrderShoppingCart> list = orderCartMapper.listByOrderId(id);
        return list;
    }
}
