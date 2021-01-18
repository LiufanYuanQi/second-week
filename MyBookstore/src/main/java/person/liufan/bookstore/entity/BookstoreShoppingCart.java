package person.liufan.bookstore.entity;

import java.util.Date;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 */
public class BookstoreShoppingCart {
    private Long id;

    private Long tbBookstoreShoppingCartUserId;

    private Long tbBookstoreShoppingCartBookId;

    private Integer tbBookstoreShoppingCartBookCount;

    private Date tbBookstoreShoppingCartCreateTime;

    private Date tbBookstoreShoppingCartUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTbBookstoreShoppingCartUserId() {
        return tbBookstoreShoppingCartUserId;
    }

    public void setTbBookstoreShoppingCartUserId(Long tbBookstoreShoppingCartUserId) {
        this.tbBookstoreShoppingCartUserId = tbBookstoreShoppingCartUserId;
    }

    public Long getTbBookstoreShoppingCartBookId() {
        return tbBookstoreShoppingCartBookId;
    }

    public void setTbBookstoreShoppingCartBookId(Long tbBookstoreShoppingCartBookId) {
        this.tbBookstoreShoppingCartBookId = tbBookstoreShoppingCartBookId;
    }

    public Integer getTbBookstoreShoppingCartBookCount() {
        return tbBookstoreShoppingCartBookCount;
    }

    public void setTbBookstoreShoppingCartBookCount(Integer tbBookstoreShoppingCartBookCount) {
        this.tbBookstoreShoppingCartBookCount = tbBookstoreShoppingCartBookCount;
    }

    public Date getTbBookstoreShoppingCartCreateTime() {
        return tbBookstoreShoppingCartCreateTime;
    }

    public void setTbBookstoreShoppingCartCreateTime(Date tbBookstoreShoppingCartCreateTime) {
        this.tbBookstoreShoppingCartCreateTime = tbBookstoreShoppingCartCreateTime;
    }

    public Date getTbBookstoreShoppingCartUpdateTime() {
        return tbBookstoreShoppingCartUpdateTime;
    }

    public void setTbBookstoreShoppingCartUpdateTime(Date tbBookstoreShoppingCartUpdateTime) {
        this.tbBookstoreShoppingCartUpdateTime = tbBookstoreShoppingCartUpdateTime;
    }
}