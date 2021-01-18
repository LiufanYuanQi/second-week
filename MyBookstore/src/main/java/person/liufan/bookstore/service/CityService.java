package person.liufan.bookstore.service;



import person.liufan.bookstore.entity.City;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/13
 *
 * city表相关service
 */
public interface CityService {
    /**
     * 通过省份编号查出的对应城市
     * @param provinceId 省份编号
     * @return 城市集合
     */
    List<City> listCity(Long provinceId);
}
