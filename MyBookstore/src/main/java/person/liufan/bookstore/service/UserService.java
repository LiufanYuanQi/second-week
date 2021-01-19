package person.liufan.bookstore.service;

import com.github.pagehelper.PageInfo;
import person.liufan.bookstore.entity.BookstoreUser;

import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 */
public interface UserService {
    /**
     * 对登录操作上传的用户进行验证
     * @param userName 用户名
     * @param password 密码
     * @return 失败返回flag=false，和message=错误原因
     *          成功返回true，和查询到的用户
     */
    Map login(String userName, String password);

    /**
     * 对上传的用户进行验证，如果用户不存在则进行保存返回是否保存成功
     * @param user
     * @return
     */
    Boolean sava(BookstoreUser user);

    /**
     * 通过用户id获取用户详情
     * @param userId userId
     * @return 记录详情
     */
    BookstoreUser getUserDetail(Long userId);

    /**
     * 根据条件分页查询记录
     * @param id 指定的id
     * @param pageNum 当前页码
     * @param pageSize 每页大小
     * @return 查询结果
     */
    PageInfo<BookstoreUser> listUserDetailByName(Long id, int pageNum, int pageSize);

    /**
     * 通过id对记录进行更新
     * @param user 记录实体
     * @return 执行结果
     */
    boolean updateUser(BookstoreUser user);

    /**
     * 通过ids进行批量删除
     * @param ids ids
     * @return 执行结果
     */
    Boolean deleteUserByIds(String[] ids);
}
