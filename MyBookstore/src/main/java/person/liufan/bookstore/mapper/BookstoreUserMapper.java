package person.liufan.bookstore.mapper;

import person.liufan.bookstore.entity.BookstoreUser;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * tb_bookstore_user代理接口
 */
public interface BookstoreUserMapper {
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
    int insert(BookstoreUser record);
    /**
     * 选择性插入一条记录
     * @param record 记录实体
     * @return 1成功，0失败
     */
    int insertSelective(BookstoreUser record);
    /**
     * 通过主键查询一条记录
     * @param id id
     * @return 1成功，0失败
     */
    BookstoreUser selectByPrimaryKey(Long id);
    /**
     * 通过主键选择性更新一套记录
     * @param record 记录实体
     * @return 1成功，0失败
     */
    int updateByPrimaryKeySelective(BookstoreUser record);
    /**
     * 通过主键更新一条记录
     * @param record 记录实体，全部非空
     * @return 1成功，0失败
     */
    int updateByPrimaryKey(BookstoreUser record);

    /**
     * 通过名字查询记录
     * @param userName 用户名
     * @return 查询结果
     */
    BookstoreUser selectByName(String userName);

    /**
     * 通过id进行查询，如果id为空则全表查询
     * @param user 记录条件
     * @return 查询结果
     */
    List<BookstoreUser> listUserById(BookstoreUser user);

    /**
     * 通过ids进行批量删除
     * @param ids ids
     * @return 执行结果
     */
    int deleteByIds(String[] ids);
}