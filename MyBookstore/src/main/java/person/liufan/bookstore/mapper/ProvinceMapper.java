package person.liufan.bookstore.mapper;

import person.liufan.bookstore.entity.Province;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/15
 */
public interface ProvinceMapper {
    /**
     * 查询所有省份
     * @return 记录集合
     */
    List<Province> listProvince();

    /**
     * 通过主键删除记录
     * @param id id
     * @return 1成功，0失败
     */
    Integer deleteByPrimaryKey(Integer id);

    /**
     * 插入一个记录
     * @param record 记录实体，所有非空
     * @return 1成功，0失败
     */
    Integer insert(Province record);

    /**
     * 选择性插入一个记录
     * @param record 记录实体
     * @return 1成功，0失败
     */
    Integer insertSelective(Province record);

    /**
     * 通过主键查询记录
     * @param id id
     * @return 记录实体
     */
    Province selectByPrimaryKey(Integer id);

    /**
     * 通过主键选择性更新记录
     * @param record 记录实体
     * @return 1成功，0失败
     */
    Integer updateByPrimaryKeySelective(Province record);

    /**
     * 通过主键更新记录
     * @param record 记录实体，非空
     * @return 1成功，0失败
     */
    Integer updateByPrimaryKey(Province record);
}