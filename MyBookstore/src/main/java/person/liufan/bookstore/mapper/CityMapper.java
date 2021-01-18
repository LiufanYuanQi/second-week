package person.liufan.bookstore.mapper;



import person.liufan.bookstore.entity.City;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/15
 */
public interface CityMapper {
    /**
     * 查询所有的城市
     * @return 所有的城市集合
     */
    List<City> listCity();

    /**
     * 删除指定id的城市
     * @param id 删除记录的id
     * @return 成功返回1，失败返回0
     */
    Integer deleteByPrimaryKey(Long id);

    /**
     * 插入一条记录
     * @param record 需要插入的城市实体类，所有字段不能为空
     * @return 成功返回1，失败返回0
     */
    Integer insert(City record);

    /**
     * 选择性的插入一条记录
     * @param record 需要插入的城市实体类，字段可以为空
     * @return 成功返回1，失败返回0
     */
    Integer insertSelective(City record);

    /**
     * 通过id查询记录
     * @param id 查询值
     * @return 查询结果
     */
    City selectByPrimaryKey(Long id);

    /**
     * 通过主键选择性更新字段
     * @param record 更新字段封装成的对象，id为对应需要修改的id
     * @return 成功返回1，失败返回0
     */
    Integer updateByPrimaryKeySelective(City record);

    /**
     * 通过主键更新字段
     * @param record 更新字段封装成的对象，id为对应需要修改的id，所有字段不能为空
     * @return
     */
    Integer updateByPrimaryKey(City record);

    /**
     * 通过省份id查询所有的城市
     * @param provinceId 省份的id
     * @return 查询到的所有城市实体集合
     */
    List<City> listCityByProvince(Long provinceId);
}