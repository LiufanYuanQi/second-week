package person.liufan.bookstore.mapper;

import person.liufan.bookstore.entity.BookstoreOrderShoppingCart;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 */
public interface BookstoreOrderShoppingCartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookstoreOrderShoppingCart record);

    int insertSelective(BookstoreOrderShoppingCart record);

    BookstoreOrderShoppingCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookstoreOrderShoppingCart record);

    int updateByPrimaryKey(BookstoreOrderShoppingCart record);
}