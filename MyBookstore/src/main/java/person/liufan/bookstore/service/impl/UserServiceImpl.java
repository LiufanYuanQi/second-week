package person.liufan.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import person.liufan.bookstore.entity.BookstoreOrder;
import person.liufan.bookstore.entity.BookstoreUser;
import person.liufan.bookstore.mapper.BookstoreUserMapper;
import person.liufan.bookstore.service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 */
@Component
public class UserServiceImpl implements UserService {
    @Resource
    private BookstoreUserMapper userMapper;

    @Override
    public Map login(String userName, String password) {
        Map map = new HashMap(4);
        BookstoreUser user = userMapper.selectByName(userName);
        /*
         * 如果用户存在返回tru及对应user
         * 用户不存在或者错误返回false及提示消息
         * */
        if (user != null) {
            boolean flag = password.equals(user.getTbBookstoreUserPassword());
            if (flag) {
                map.put("flag", true);
                map.put("user", user);
                return map;
            }
        }
        map.put("flag", false);
        map.put("message", "账号验证错误");
        return map;
    }

    @Override
    public Boolean sava(BookstoreUser user) {
        BookstoreUser rest = userMapper.selectByName(user.getTbBookstoreUserName());
        if (rest != null) {
            return false;
        }
        Integer flag = userMapper.insertSelective(user);
        return flag == 1;
    }

    @Override
    public BookstoreUser getUserDetail(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public PageInfo<BookstoreUser> listUserDetailByName(Long id, int pageNum, int pageSize) {
        BookstoreUser user = new BookstoreUser();
        user.setId(id);
        PageHelper.startPage(pageNum, pageSize);
        List<BookstoreUser> list = userMapper.listUserById(user);
        PageInfo<BookstoreUser> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public boolean updateUser(BookstoreUser user) {
        int flag = userMapper.updateByPrimaryKeySelective(user);
        return flag == 1;
    }
    @Override
    public Boolean deleteUserByIds(String[] ids) {
        int flag = userMapper.deleteByIds(ids);
        return flag == 1;
    }
}
