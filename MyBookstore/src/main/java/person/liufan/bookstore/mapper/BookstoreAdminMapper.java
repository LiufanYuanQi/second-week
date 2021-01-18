package person.liufan.bookstore.mapper;

import org.apache.ibatis.annotations.Mapper;
import person.liufan.bookstore.entity.BookstoreAdmin;

import java.util.List;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 */
public interface BookstoreAdminMapper {
    List<BookstoreAdmin> listAdmin();

    int deleteByPrimaryKey(Long id);

    int insert(BookstoreAdmin record);

    int insertSelective(BookstoreAdmin record);

    BookstoreAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookstoreAdmin record);

    int updateByPrimaryKey(BookstoreAdmin record);
}