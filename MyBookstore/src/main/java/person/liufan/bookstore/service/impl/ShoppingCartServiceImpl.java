package person.liufan.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import person.liufan.bookstore.entity.BookstoreBook;
import person.liufan.bookstore.entity.BookstoreShoppingCart;
import person.liufan.bookstore.mapper.BookstoreBookMapper;
import person.liufan.bookstore.mapper.BookstoreShoppingCartMapper;
import person.liufan.bookstore.service.ShoppingCartService;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/20
 */
@Component
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    private BookstoreShoppingCartMapper cartMapper;
    @Resource
    private BookstoreBookMapper bookMapper;
    @Override
    public Map addToCartByBookId(String[] ids,Long userId) {
        Map map = new HashMap(4);
        boolean flag = false;
        String message = "全部添加成功";
        for (int i = 0; i < ids.length; i++) {
            BookstoreShoppingCart query = new BookstoreShoppingCart();
            query.setTbBookstoreShoppingCartUserId(userId);
            query.setTbBookstoreShoppingCartBookId(Long.valueOf(ids[i]));
            query.setTbBookstoreShoppingCartBookCount(1);
            query.setTbBookstoreShoppingCartCreateTime(new Date());
            BookstoreShoppingCart cart = cartMapper.selectByUserIdAndBookId(query);
            if (cart == null) {
                cartMapper.insertSelective(query);
                flag = true;
            } else {
                message = "部分商品已在购物车中，将剩余部分添加到购物车";
            }
        }
        if (flag) {
            map.put("flag", true);
            map.put("message", message);
            return map;
        }
        map.put("flag", false);
        map.put("message", "添加失败");
        return map;
    }

    @Override
    public Boolean sava(BookstoreShoppingCart cart) {
        BookstoreShoppingCart rest = cartMapper.selectByUserIdAndBookId(cart);
        if (rest == null) {
            int flag = cartMapper.insertSelective(cart);
            return flag == 1;
        }
        return false;
    }

    @Override
    public BookstoreShoppingCart selectById(Long cartId) {
        return cartMapper.selectByPrimaryKey(cartId);
    }

    @Override
    public boolean updateById(BookstoreShoppingCart cart) {
        int flag = cartMapper.updateByPrimaryKeySelective(cart);
        return flag == 1;
    }

    @Override
    public Boolean deleteCartByIds(String[] ids) {
        int flag = cartMapper.deleteByIds(ids);
        return flag == 1;
    }

    @Override
    public Map createOrderByIds(String[] ids) {
        List<BookstoreShoppingCart> carts = cartMapper.selectByIds(ids);
        List cartList = new ArrayList();
        List messageList = new ArrayList();
        for (BookstoreShoppingCart cart : carts) {
            BookstoreBook book = bookMapper.selectByPrimaryKey(cart.getTbBookstoreShoppingCartBookId());
            if (cart.getTbBookstoreShoppingCartBookCount() <= book.getTbBookstoreBookNumber()) {
                cartList.add(cart);
            } else {
                messageList.add(book.getTbBookstoreBookName());
            }
        }
        Map map = new HashMap(4);
        map.put("cartList", cartList);
        map.put("message", messageList);
        return map;
    }

    @Override
    public PageInfo<BookstoreShoppingCart> listCartDetailByName(Long id,Long userId, int pageNum, int pageSize) {
        BookstoreShoppingCart cart = new BookstoreShoppingCart();
        cart.setId(id);
        cart.setTbBookstoreShoppingCartUserId(userId);
        PageHelper.startPage(pageNum, pageSize);
        List<BookstoreShoppingCart> list = cartMapper.listCartById(cart);
        PageInfo<BookstoreShoppingCart> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
