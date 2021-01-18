package person.liufan.bookstore.entity;

import java.util.Date;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 */
public class BookstoreUser {
    private Long id;

    private String tbBookstoreUserName;

    private String tbBookstoreUserPassword;

    private String tbBookstoreUserRealName;

    private String tbBookstoreUserPhone;

    private String tbBookstoreUserEmail;

    private Long tbBookstoreUserCityId;

    private String tbBookstoreUserAddress;

    private String tbBookstoreUserHobby;

    private Date tbBookstoreUserCreateTime;

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