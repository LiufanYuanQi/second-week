package person.liufan.bookstore.mapper;

import person.liufan.bookstore.entity.BookstoreBook;
import person.liufan.bookstore.entity.BookstoreUser;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * tb_bookstore_book管理员用户表代理接口
 */
public interface BookstoreBookMapper {
    /**
     * 通过主键删除记录
     * @param id id
     * @return 1成功，0失败
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入一条记录
     * @param record 记录实体，全部非空
     * @return 1成功，0失败
     */
    int insert(BookstoreBook record);

    /**
     * 选择性插入一条记录
     * @param record 记录实体
     * @return 1成功，0失败
     */
    int insertSelective(BookstoreBook record);

    /**
     * 通过主键查询一条记录
     * @param id id
     * @return 1成功，0失败
     */
    BookstoreBook selectByPrimaryKey(Long id);

    /**
     * 通过主键选择性更新一套记录
     * @param record 记录实体
     * @return 1成功，0失败
     */
    int updateByPrimaryKeySelective(BookstoreBook record);

    /**
     * 通过主键更新一条记录
     * @param record 记录实体，全部非空
     * @return 1成功，0失败
     */
    int updateByPrimaryKey(BookstoreBook record);

    /**
     * 通过书名进行查询
     * @param tbBookstoreBookName 书名
     * @return 查询结果
     */
    BookstoreUser selectByName(String tbBookstoreBookName);

    /**
     * 通过id进行查询，id没有全表查询
     * @param book id
     * @return 查询结果
     */
    List<BookstoreUser> listUserById(BookstoreBook book);

    /**
     * 通过ids进行批量删除
     * @param ids ids
     * @return 删除结果
     */
    int deleteByIds(String[] ids);
}