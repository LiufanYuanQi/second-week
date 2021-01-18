package person.liufan.bookstore.service.impl;


import org.springframework.stereotype.Component;
import person.liufan.bookstore.entity.City;
import person.liufan.bookstore.mapper.CityMapper;
import person.liufan.bookstore.service.CityService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/13
 */
@Component
public class CityServiceImpl implements CityService {
    @Resource
    private CityMapper cityMapper;
    @Override
    public List<City> listCity(Long provinceId) {
        List<City> cities = cityMapper.listCityByProvince(provinceId);
        return cities;
    }
}
