package person.liufan.bookstore.mapper;

import person.liufan.bookstore.entity.BookstoreShoppingCart;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * tb_bookstore_shopping_cart代理接口
 */
public interface BookstoreShoppingCartMapper {
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
    int insert(BookstoreShoppingCart record);
    /**
     * 选择性插入一条记录
     * @param record 记录实体
     * @return 1成功，0失败
     */
    int insertSelective(BookstoreShoppingCart record);
    /**
     * 通过主键查询一条记录
     * @param id id
     * @return 1成功，0失败
     */
    BookstoreShoppingCart selectByPrimaryKey(Long id);
    /**
     * 通过主键选择性更新一套记录
     * @param record 记录实体
     * @return 1成功，0失败
     */
    int updateByPrimaryKeySelective(BookstoreShoppingCart record);
    /**
     * 通过主键更新一条记录
     * @param record 记录实体，全部非空
     * @return 1成功，0失败
     */
    int updateByPrimaryKey(BookstoreShoppingCart record);

    /**
     * 通过用户id和图书id查询购物车中是否有这条记录
     * @param query 查询条件
     * @return 查询结果
     */
    BookstoreShoppingCart selectByUserIdAndBookId(BookstoreShoppingCart query);

    /**
     * 通过ids删除记录
     * @param ids ids
     * @return 操作结果
     */
    int deleteByIds(String[] ids);

    /**
     * 通过ids查询记录
     * @param ids ids
     * @return 查询结果
     */
    List<BookstoreShoppingCart> selectByIds(String[] ids);
    /**
     * 通过id进行查询，如果id不存在则全表查询
     * @param cart id
     * @return 查询结果
     */
    List<BookstoreShoppingCart> listCartById(BookstoreShoppingCart cart);
}