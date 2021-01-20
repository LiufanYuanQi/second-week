package person.liufan.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import person.liufan.bookstore.entity.BookstoreBook;
import person.liufan.bookstore.entity.BookstoreUser;
import person.liufan.bookstore.mapper.BookstoreBookMapper;
import person.liufan.bookstore.service.BookService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/19
 */
@Component
public class BookServiceImpl implements BookService {
    @Resource
    private BookstoreBookMapper bookMapper;
    @Override
    public Boolean sava(BookstoreBook bookstoreBook) {
        BookstoreUser rest = bookMapper.selectByName(bookstoreBook.getTbBookstoreBookName());
        if (rest != null) {
            return false;
        }
        Integer flag = bookMapper.insertSelective(bookstoreBook);
        return flag == 1;
    }

    @Override
    public PageInfo<BookstoreBook> listBookDetailByName(Long id, int pageNum, int pageSize) {
        BookstoreBook book = new BookstoreBook();
        book.setId(id);
        PageHelper.startPage(pageNum, pageSize);
        List<BookstoreBook> list = bookMapper.listBookById(book);
        PageInfo<BookstoreBook> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public BookstoreBook selectById(Long bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public boolean updateById(BookstoreBook book) {
        int flag = bookMapper.updateByPrimaryKeySelective(book);
        return flag == 1;
    }

    @Override
    public Boolean deleteUserByIds(String[] ids) {
        int flag = bookMapper.deleteByIds(ids);
        return flag == 1;
    }
}
