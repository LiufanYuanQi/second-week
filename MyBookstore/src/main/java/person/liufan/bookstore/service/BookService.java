package person.liufan.bookstore.service;

import com.github.pagehelper.PageInfo;
import person.liufan.bookstore.entity.BookstoreBook;
import person.liufan.bookstore.entity.BookstoreUser;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/19
 */
public interface BookService {
    /**
     * 保存一个新的书本实体类
     * @param bookstoreBook 实体类
     * @return 是否保存成功
     */
    Boolean sava(BookstoreBook bookstoreBook);

    /**
     * 通过分页参数查询结果
     * @param id id
     * @param pageNum 当前页码
     * @param pageSize 每页大小
     * @return 查询结果
     */
    PageInfo<BookstoreUser> listUserDetailByName(Long id, int pageNum, int pageSize);

    /**
     * 通过主键进行查询
     * @param bookId id
     * @return 记录实体
     */
    BookstoreBook selectById(Long bookId);

    /**
     * 通过主键更新数据
     * @param book 记录实体
     * @return 执行结果
     */
    boolean updateById(BookstoreBook book);

    /**
     * 通过ids进行批量删除
     * @param ids ids
     * @return 执行结果
     */
    Boolean deleteUserByIds(String[] ids);
}
