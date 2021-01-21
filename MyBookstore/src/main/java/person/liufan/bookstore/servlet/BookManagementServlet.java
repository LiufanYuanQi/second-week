package person.liufan.bookstore.servlet;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import person.liufan.bookstore.constant.MyConstant;
import person.liufan.bookstore.entity.BookstoreBook;
import person.liufan.bookstore.entity.BookstoreUser;
import person.liufan.bookstore.service.BookService;
import person.liufan.bookstore.util.MyPrintOut;
import person.liufan.bookstore.vo.BookDetaillVO;
import person.liufan.bookstore.vo.UserDetailVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 图书管理信息的servlet
 * 路径为/admin/book
 * 根据上传的type类型，对图书表book进行增删改查操作
 * type类型
 * queryDetail：查询所有的书本信息，包装成vo返回，实现分页
 * vo字段：
 * queryById：通过id查询详情
 * updateById：通过id进行更新
 * deleteByIds：通过ids进行批量删除
 */
@Component
@WebServlet("/up")
@MultipartConfig
public class BookManagementServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String attr = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        WebApplicationContext ac = (WebApplicationContext) this.getServletContext().getAttribute(attr);
        BookService bookService = (BookService) ac.getBean("bookServiceImpl");
        String type = request.getParameter(MyConstant.TYPE);
        /**
         * 处理新增图书的请求，将请求中的参数封装成对象进行保存
         */
        if (MyConstant.TYPE_SAVE.equals(type)) {
            BookstoreBook book = toBook(request);
            book.setTbBookstoreBookCreateTime(new Date());
            Boolean flag = bookService.sava(book);
            MyPrintOut.printJson(response,flag);
        }
        /**
         * 处理根据id查询具体记录的请求，用于回响数据
         * 返回查询到的结果即可
         */
        if (MyConstant.TYPE_QUERY_BY_ID.equals(type)) {
            BookstoreBook book = bookService.selectById(Long.valueOf(request.getParameter(MyConstant.PARAMETER_ID)));
            MyPrintOut.printJson(response, book);
        }
        /**
         * 处理查询图书记录的请求，使用分页展示
         */
        if (MyConstant.TYPE_QUERY_DETAIL.equals(type)) {
            String bookId = request.getParameter(MyConstant.PARAMETER_ID);
            Long id = null;
            if (bookId != null && bookId != "") {
                id = Long.valueOf(bookId);
            }
            int pageNum = Integer.parseInt(request.getParameter("pageNum"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            PageInfo<BookstoreBook> pageInfo = bookService.listBookDetailByName(id,pageNum,pageSize);
            Map map = new HashMap(8);
            List<BookstoreBook> list = pageInfo.getList();
            Long count = pageInfo.getTotal();
            List<BookDetaillVO> voList = new ArrayList<>(Math.toIntExact(count));
            for (BookstoreBook book : list) {
                BookDetaillVO vo = new BookDetaillVO();
                vo.setId(book.getId());
                vo.setTbBookstoreBookName(book.getTbBookstoreBookName());
                vo.setTbBookstoreBookPictureUrl(book.getTbBookstoreBookPictureUrl());
                vo.setTbBookstoreBookAuthor(book.getTbBookstoreBookAuthor());
                vo.setTbBookstoreBookPublishing(book.getTbBookstoreBookPublishing());
                vo.setTbBookstoreBookPrice(book.getTbBookstoreBookPrice());
                vo.setTbBookstoreBookNumber(book.getTbBookstoreBookNumber());
                vo.setTbBookstoreBookInfo(book.getTbBookstoreBookInfo());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                vo.setTbBookstoreBookCreateTime(simpleDateFormat.format(book.getTbBookstoreBookCreateTime()));
                voList.add(vo);
            }
            map.put("count", count);
            map.put("data", voList);
            MyPrintOut.printJson(response, map);
        }
        /**
         * 处理更新的业务请求
         */
        if (MyConstant.TYPE_UPDATE.equals(type)) {
            BookstoreBook book = toBook(request);
            book.setId(Long.valueOf(request.getParameter(MyConstant.PARAMETER_ID)));
            book.setTbBookstoreBookUpdateTime(new Date());
            boolean flag = bookService.updateById(book);
            MyPrintOut.printJson(response, flag);
        }
        /**
         * 处理批量删除的业务请求
         */
        if (MyConstant.TYPE_DELETE.equals(type)) {
            String param = request.getParameter("deleteList");
            String[] ids = param.split("&");
            Boolean flag = bookService.deleteUserByIds(ids);
            MyPrintOut.printJson(response, flag);
        }
    }
    private BookstoreBook toBook(HttpServletRequest request) {
        /**
         * pictureUrl
         * name
         * author
         * publishing
         * price
         * number
         * info
         */
        String url = request.getParameter("pictureUrl");
        String name =request.getParameter(MyConstant.PARAMETER_NAME);
        String author =request.getParameter(MyConstant.PARAMETER_AUTHOR);
        String publishing =request.getParameter(MyConstant.PARAMETER_PUBLISHING);
        String price =request.getParameter(MyConstant.PARAMETER_PRICE);
        String number =request.getParameter(MyConstant.PARAMETER_NUMBER);
        String info =request.getParameter(MyConstant.PARAMETER_INFO);

        BigDecimal bigDecimalPrice = new BigDecimal(price);
        BookstoreBook book = new BookstoreBook();
        book.setTbBookstoreBookPictureUrl(url);
        book.setTbBookstoreBookName(name);
        book.setTbBookstoreBookAuthor(author);
        book.setTbBookstoreBookPublishing(publishing);
        book.setTbBookstoreBookPrice(bigDecimalPrice);
        book.setTbBookstoreBookNumber(Integer.valueOf(number));
        book.setTbBookstoreBookInfo(info);

        return book;
    }
}
