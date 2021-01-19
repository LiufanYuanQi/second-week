package person.liufan.bookstore.vo;

import java.util.Date;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/19
 */
public class UserDetailVO {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名
     */
    private String tbBookstoreUserName;
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
     * 用户所在城市
     */
    private String tbBookstoreUserProvinceAndCity;
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
    private String tbBookstoreUserCreateTime;

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

    public String getTbBookstoreUserProvinceAndCity() {
        return tbBookstoreUserProvinceAndCity;
    }

    public void setTbBookstoreUserProvinceAndCity(String tbBookstoreUserProvinceAndCity) {
        this.tbBookstoreUserProvinceAndCity = tbBookstoreUserProvinceAndCity;
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

    public String getTbBookstoreUserCreateTime() {
        return tbBookstoreUserCreateTime;
    }

    public void setTbBookstoreUserCreateTime(String tbBookstoreUserCreateTime) {
        this.tbBookstoreUserCreateTime = tbBookstoreUserCreateTime;
    }

    @Override
    public String toString() {
        return "UserDetailVO{" +
                "id=" + id +
                ", tbBookstoreUserName='" + tbBookstoreUserName + '\'' +
                ", tbBookstoreUserRealName='" + tbBookstoreUserRealName + '\'' +
                ", tbBookstoreUserPhone='" + tbBookstoreUserPhone + '\'' +
                ", tbBookstoreUserEmail='" + tbBookstoreUserEmail + '\'' +
                ", tbBookstoreUserProvinceAndCity='" + tbBookstoreUserProvinceAndCity + '\'' +
                ", tbBookstoreUserAddress='" + tbBookstoreUserAddress + '\'' +
                ", tbBookstoreUserHobby='" + tbBookstoreUserHobby + '\'' +
                ", tbBookstoreUserCreateTime=" + tbBookstoreUserCreateTime +
                '}';
    }
}
