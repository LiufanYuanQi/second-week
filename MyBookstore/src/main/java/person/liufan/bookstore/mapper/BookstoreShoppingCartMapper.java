package person.liufan.bookstore.mapper;

import person.liufan.bookstore.entity.BookstoreShoppingCart;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 */
public interface BookstoreShoppingCartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookstoreShoppingCart record);

    int insertSelective(BookstoreShoppingCart record);

    BookstoreShoppingCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookstoreShoppingCart record);

    int updateByPrimaryKey(BookstoreShoppingCart record);
}