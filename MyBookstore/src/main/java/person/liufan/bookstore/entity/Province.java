package person.liufan.bookstore.entity;

import java.beans.Transient;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/15
 * think_province实体类，保存省份信息
 */
public class Province {
    /**
     * id
     */
    private Integer id;
    /**
     * 省份名称
     */
    private String name;
    /**
     * 区域名称
     */
    private String alias;
    /**
     * 是否是资源城市
     */
    private Byte resource;
    /**
     * 省份所有的城市
     */
    private List<City> cities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Byte getResource() {
        return resource;
    }

    public void setResource(Byte resource) {
        this.resource = resource;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}