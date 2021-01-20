package person.liufan.bookstore.service;

import com.github.pagehelper.PageInfo;
import person.liufan.bookstore.entity.BookstoreShoppingCart;

import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/20
 */
public interface ShoppingCartService {
    /**
     * 处理批量将书本添加到购物车的请求，前端将批量发送添加的书本ids，
     * 后端获取当前登录的用户id，将两者映射保存到购物车中，购买数量默认设置为1
     * 首先进行查询，当不存在时进行添加
     * 当部分保存时候返回结果，flag为true，并提示message
     * 当全部保存失败时，返回结果为false，并提示消息
     * @param ids 需要添加到购物车的ids
     * @param userId 用户id
     * @return 是否添加成功
     */
    Map addToCartByBookId(String[] ids,Long userId);

    /**
     * 处理保存请求，将前端发送的书本id，数量，和后端获取的用户id进行绑定
     * 保存到数据库中
     * 首先进行查询，如果不存在则添加，存在返回false
     * @param cart 需要添加的数据库实体
     * @return 添加结果
     */
    Boolean sava(BookstoreShoppingCart cart);

    /**
     * 通过id查询购物车记录，将查询结果返回给前端，用于页面渲染，需要返回查询到的书籍结果
     * @param cartId id
     * @return 查询结果
     */
    BookstoreShoppingCart selectById(Long cartId);

    /**
     * 根据id进行更新
     * @param cart 记录实体
     * @return 操作结果
     */
    boolean updateById(BookstoreShoppingCart cart);

    /**
     * 通过主键id批量删除购物车记录
     * @param ids ids
     * @return 删除结果
     */
    Boolean deleteCartByIds(String[] ids);

    /**
     * 通过主键id返回书籍信息购物车信息，用于前端渲染页面
     * 发送的id为购物车中选中商品的id，
     * 首先获取这些id，获取出其对应的cartList合集
     * 然后进行遍历，当cart中的购买数量小于库存的时候，添加到list中，大于库存时，将name添加到messageList中，
     * @param ids 需要进行操作的
     * @return map，cartList，
     *              messageList，
     */
    Map createOrderByIds(String[] ids);

    /**
     * 通过分页查询所有的cart
     * @param id id
     * @param userId userId
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    PageInfo<BookstoreShoppingCart> listCartDetailByName(Long id,Long userId, int pageNum, int pageSize);
}
