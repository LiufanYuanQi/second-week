package person.liufan.bookstore.service;


import person.liufan.bookstore.entity.Province;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/13
 */
public interface ProvinceService {
    /**
     * 查询所有的省份
     * @return 查询到的省份集合
     */
    List<Province> listProvince();
    /**
     * 通过省份id和城市id查询对应的省市并返回province/city形式
     * @param provinceId 需要查询的省份id
     * @param cityId 需要查询的城市id
     * @return 查询到的省份和城市
     */
    String getProvinceAndCity(Integer provinceId, Long cityId);
}
