package person.liufan.bookstore.entity;

import java.util.Date;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 用户实体类
 */
public class BookstoreUser {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名
     */
    private String tbBookstoreUserName;
    /**
     * 用户密码
     */
    private String tbBookstoreUserPassword;
    /**
     * 用户真实姓名
     */
    private String tbBookstoreUserRealName;
    /**
     * 用户手机号
     */
    private String tbBookstoreUserPhone;
    /**
     * 用户邮箱
     */
    private String tbBookstoreUserEmail;
    /**
     * 用户所在城市id，关联表think_province
     */
    private Long tbBookstoreUserCityId;
    /**
     * 用户地址
     */
    private String tbBookstoreUserAddress;
    /**
     * 用户爱好
     */
    private String tbBookstoreUserHobby;
    /**
     * 创建时间
     */
    private Date tbBookstoreUserCreateTime;
    /**
     * 修改时间
     */
    private Date tbBookstoreUserUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTbBookstoreUserName() {
        return tbBookstoreUserName;
    }

    public void setTbBookstoreUserName(String tbBookstoreUserName) {
        this.tbBookstoreUserName = tbBookstoreUserName;
    }

    public String getTbBookstoreUserPassword() {
        return tbBookstoreUserPassword;
    }

    public void setTbBookstoreUserPassword(String tbBookstoreUserPassword) {
        this.tbBookstoreUserPassword = tbBookstoreUserPassword;
    }

    public String getTbBookstoreUserRealName() {
        return tbBookstoreUserRealName;
    }

    public void setTbBookstoreUserRealName(String tbBookstoreUserRealName) {
        this.tbBookstoreUserRealName = tbBookstoreUserRealName;
    }

    public String getTbBookstoreUserPhone() {
        return tbBookstoreUserPhone;
    }

    public void setTbBookstoreUserPhone(String tbBookstoreUserPhone) {
        this.tbBookstoreUserPhone = tbBookstoreUserPhone;
    }

    public String getTbBookstoreUserEmail() {
        return tbBookstoreUserEmail;
    }

    public void setTbBookstoreUserEmail(String tbBookstoreUserEmail) {
        this.tbBookstoreUserEmail = tbBookstoreUserEmail;
    }

    public Long getTbBookstoreUserCityId() {
        return tbBookstoreUserCityId;
    }

    public void setTbBookstoreUserCityId(Long tbBookstoreUserCityId) {
        this.tbBookstoreUserCityId = tbBookstoreUserCityId;
    }

    public String getTbBookstoreUserAddress() {
        return tbBookstoreUserAddress;
    }

    public void setTbBookstoreUserAddress(String tbBookstoreUserAddress) {
        this.tbBookstoreUserAddress = tbBookstoreUserAddress;
    }

    public String getTbBookstoreUserHobby() {
        return tbBookstoreUserHobby;
    }

    public void setTbBookstoreUserHobby(String tbBookstoreUserHobby) {
        this.tbBookstoreUserHobby = tbBookstoreUserHobby;
    }

    public Date getTbBookstoreUserCreateTime() {
        return tbBookstoreUserCreateTime;
    }

    public void setTbBookstoreUserCreateTime(Date tbBookstoreUserCreateTime) {
        this.tbBookstoreUserCreateTime = tbBookstoreUserCreateTime;
    }

    public Date getTbBookstoreUserUpdateTime() {
        return tbBookstoreUserUpdateTime;
    }

    public void setTbBookstoreUserUpdateTime(Date tbBookstoreUserUpdateTime) {
        this.tbBookstoreUserUpdateTime = tbBookstoreUserUpdateTime;
    }
}