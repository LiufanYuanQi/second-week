package person.liufan.bookstore.mapper;

import person.liufan.bookstore.entity.BookstoreUser;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 */
public interface BookstoreUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookstoreUser record);

    int insertSelective(BookstoreUser record);

    BookstoreUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookstoreUser record);

    int updateByPrimaryKey(BookstoreUser record);
}