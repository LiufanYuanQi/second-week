package person.liufan.bookstore.entity;

import java.util.Date;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 管理员实体类
 */
public class BookstoreAdmin {
    /**
     * 管理员id
     */
    private Long id;
    /**
     * 管理员名字
     */
    private String tbBookstoreAdminName;
    /**
     * 管理员密码
     */
    private String tbBookstoreAdminPassword;
    /**
     * 创建时间
     */
    private Date tbBookstoreAdminCreateTime;
    /**
     * 更新时间
     */
    private Date tbBookstoreAdminUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTbBookstoreAdminName() {
        return tbBookstoreAdminName;
    }

    public void setTbBookstoreAdminName(String tbBookstoreAdminName) {
        this.tbBookstoreAdminName = tbBookstoreAdminName;
    }

    public String getTbBookstoreAdminPassword() {
        return tbBookstoreAdminPassword;
    }

    public void setTbBookstoreAdminPassword(String tbBookstoreAdminPassword) {
        this.tbBookstoreAdminPassword = tbBookstoreAdminPassword;
    }

    public Date getTbBookstoreAdminCreateTime() {
        return tbBookstoreAdminCreateTime;
    }

    public void setTbBookstoreAdminCreateTime(Date tbBookstoreAdminCreateTime) {
        this.tbBookstoreAdminCreateTime = tbBookstoreAdminCreateTime;
    }

    public Date getTbBookstoreAdminUpdateTime() {
        return tbBookstoreAdminUpdateTime;
    }

    public void setTbBookstoreAdminUpdateTime(Date tbBookstoreAdminUpdateTime) {
        this.tbBookstoreAdminUpdateTime = tbBookstoreAdminUpdateTime;
    }
}