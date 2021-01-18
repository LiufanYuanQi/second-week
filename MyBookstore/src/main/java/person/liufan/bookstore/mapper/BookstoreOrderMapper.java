package person.liufan.bookstore.mapper;

import person.liufan.bookstore.entity.BookstoreOrder;

public interface BookstoreOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookstoreOrder record);

    int insertSelective(BookstoreOrder record);

    BookstoreOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookstoreOrder record);

    int updateByPrimaryKey(BookstoreOrder record);
}