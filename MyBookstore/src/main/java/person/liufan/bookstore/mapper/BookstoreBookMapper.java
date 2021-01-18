package person.liufan.bookstore.mapper;

import person.liufan.bookstore.entity.BookstoreBook;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 */
public interface BookstoreBookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookstoreBook record);

    int insertSelective(BookstoreBook record);

    BookstoreBook selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookstoreBook record);

    int updateByPrimaryKey(BookstoreBook record);
}