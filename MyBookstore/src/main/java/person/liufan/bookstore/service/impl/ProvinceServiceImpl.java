package person.liufan.bookstore.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import person.liufan.bookstore.entity.City;
import person.liufan.bookstore.entity.Province;
import person.liufan.bookstore.mapper.CityMapper;
import person.liufan.bookstore.mapper.ProvinceMapper;
import person.liufan.bookstore.service.ProvinceService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/13
 */
@Component
public class ProvinceServiceImpl implements ProvinceService {
    @Resource
    ProvinceMapper provinceMapper;
    @Autowired
    private CityMapper cityMapper;
    @Override
    public List<Province> listProvince() {
        List<Province> provinces = provinceMapper.listProvince();
        return provinces;
    }

    @Override
    public String getProvinceAndCity(Integer provinceId, Long cityId) {
        Province province = provinceMapper.selectByPrimaryKey(provinceId);
        City city = cityMapper.selectByPrimaryKey(cityId);
        String  provinceAndCity = province.getName() + "/" + city.getCity();
        return provinceAndCity;
    }
}
