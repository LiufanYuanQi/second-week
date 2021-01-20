package person.liufan.bookstore.servlet;

import com.github.pagehelper.PageInfo;
import org.springframework.web.context.WebApplicationContext;
import person.liufan.bookstore.constant.MyConstant;
import person.liufan.bookstore.entity.BookstoreUser;
import person.liufan.bookstore.entity.City;
import person.liufan.bookstore.entity.Province;
import person.liufan.bookstore.service.CityService;
import person.liufan.bookstore.service.ProvinceService;
import person.liufan.bookstore.service.UserService;
import person.liufan.bookstore.service.impl.ProvinceServiceImpl;
import person.liufan.bookstore.util.MyPrintOut;
import person.liufan.bookstore.vo.UserDetailVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 用户管理信息的servlet
 * 路径为/admin/user
 * 根据上传的type类型，对用户表user进行增删改查操作
 * type类型
 * queryDetail：查询所有的用户信息，包装成vo返回，实现分页
 *              vo字段
 * queryById：通过id查询详情
 * updateById：通过id进行更新
 * deleteByIds：通过ids进行批量删除
 */
public class UserManagementServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String attr = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        WebApplicationContext ac = (WebApplicationContext) this.getServletContext().getAttribute(attr);
        UserService userService = (UserService) ac.getBean("userServiceImpl");
        CityService cityService = (CityService) ac.getBean("cityServiceImpl");
        ProvinceService provinceService = (ProvinceService) ac.getBean("provinceServiceImpl");
        String type = request.getParameter(MyConstant.TYPE);
        if (MyConstant.TYPE_QUERY_BY_ID.equals(type)) {
            String userId = request.getParameter(MyConstant.PARAMETER_ID);
            BookstoreUser userDetail = userService.getUserDetail(Long.valueOf(userId));
            City city = cityService.selectCityById(userDetail.getTbBookstoreUserCityId());
            Long provinceId = city.getProvinceId();
            List<Province> provinces = provinceService.listProvince();
            List<City> cities = cityService.listCity(provinceId);
            Map map = new HashMap(8);
            map.put("user", userDetail);
            map.put("provinceId", provinceId);
            map.put("provinces", provinces);
            map.put("cities", cities);
            MyPrintOut.printJson(response,map);
        }
        if (MyConstant.TYPE_QUERY_DETAIL.equals(type)) {
            String userId = request.getParameter(MyConstant.PARAMETER_ID);
            Long id = null;
            if (userId != null && userId!="") {
                id = Long.valueOf(userId);
            }
            int pageNum = Integer.parseInt(request.getParameter("pageNum"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            PageInfo<BookstoreUser> pageInfo = userService.listUserDetailByName(id,pageNum,pageSize);
            List<UserDetailVO> voList = toUserDetailVO(pageInfo,provinceService,cityService);
            Map map = new HashMap(8);
            map.put("count", pageInfo.getTotal());
            map.put("data", voList);
            MyPrintOut.printJson(response, map);
        }
        if (MyConstant.TYPE_UPDATE.equals(type)) {
            BookstoreUser user = toUser(request);
            boolean flag = userService.updateUser(user);
            MyPrintOut.printJson(response, flag);
        }
        if (MyConstant.TYPE_DELETE.equals(type)) {
            String param = request.getParameter("deleteList");
            String[] ids = param.split("&");
            Boolean flag = userService.deleteUserByIds(ids);
            MyPrintOut.printJson(response, flag);
        }
        if (MyConstant.TYPE_EXIT.equals(type)) {
            request.getSession().removeAttribute("user");
            MyPrintOut.printJson(response,true);
        }
    }

    private BookstoreUser toUser(HttpServletRequest request) {
        String id = request.getParameter(MyConstant.PARAMETER_ID);
        String name =request.getParameter(MyConstant.PARAMETER_NAME);
        String password =request.getParameter(MyConstant.PARAMETER_PASSWORD);
        String realName =request.getParameter(MyConstant.PARAMETER_REAL_NAME);
        String phone =request.getParameter(MyConstant.PARAMETER_PHONE);
        String email =request.getParameter(MyConstant.PARAMETER_EMAIL);
        String cityId =request.getParameter(MyConstant.PARAMETER_CITY_ID);
        String address =request.getParameter(MyConstant.PARAMETER_ADDRESS);
        String hobbies =request.getParameter(MyConstant.PARAMETER_HOBBIES);

        BookstoreUser user = new BookstoreUser();
        user.setId(Long.valueOf(id));
        user.setTbBookstoreUserName(name);
        user.setTbBookstoreUserPassword(password);
        user.setTbBookstoreUserRealName(realName);
        user.setTbBookstoreUserPhone(phone);
        user.setTbBookstoreUserEmail(email);
        user.setTbBookstoreUserCityId(Long.valueOf(cityId));
        user.setTbBookstoreUserAddress(address);
        user.setTbBookstoreUserHobby(hobbies);
        user.setTbBookstoreUserUpdateTime(new Date());
        return user;
    }

    private List<UserDetailVO> toUserDetailVO(PageInfo<BookstoreUser> pageInfo,ProvinceService provinceService,CityService cityService) {
        List<BookstoreUser> users = pageInfo.getList();
        List<UserDetailVO> voList = new ArrayList<>();
        for (BookstoreUser obj : users) {
            UserDetailVO vo = new UserDetailVO();
            vo.setId(obj.getId());
            vo.setTbBookstoreUserName(obj.getTbBookstoreUserName());
            vo.setTbBookstoreUserRealName(obj.getTbBookstoreUserRealName());
            vo.setTbBookstoreUserPhone(obj.getTbBookstoreUserPhone());
            vo.setTbBookstoreUserEmail(obj.getTbBookstoreUserEmail());
            vo.setTbBookstoreUserAddress(obj.getTbBookstoreUserAddress());
            vo.setTbBookstoreUserHobby(obj.getTbBookstoreUserHobby());
            City city = cityService.selectCityById(obj.getTbBookstoreUserCityId());
            Long provinceId = city.getProvinceId();
            String provinceAndCity = getProvinceAndCity(provinceService,Math.toIntExact(provinceId), city.getId());
            vo.setTbBookstoreUserProvinceAndCity(provinceAndCity);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            vo.setTbBookstoreUserCreateTime(simpleDateFormat.format(obj.getTbBookstoreUserCreateTime()));
            voList.add(vo);
        }
        return voList;
    }
    private String getProvinceAndCity(ProvinceService provinceService,Integer provinceId, Long cityId) {
        String provinceAndCity = provinceService.getProvinceAndCity(provinceId, cityId);
        return provinceAndCity;
    }
}
