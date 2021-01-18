package person.liufan.bookstore.service;

import org.springframework.stereotype.Component;
import person.liufan.bookstore.entity.BookstoreAdmin;
import person.liufan.bookstore.mapper.BookstoreAdminMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 */
@Component
public class TestService {

    @Resource
    private BookstoreAdminMapper adminMapper;

    public List<BookstoreAdmin> listAdmin() {
        return adminMapper.listAdmin();
    }
}
