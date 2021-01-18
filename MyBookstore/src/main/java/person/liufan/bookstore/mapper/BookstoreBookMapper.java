package person.liufan.bookstore.mapper;

import person.liufan.bookstore.entity.BookstoreBook;
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
}