package person.liufan.bookstore.entity;

import java.util.Date;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 */
public class BookstoreOrderShoppingCart {
    private Long id;

    private Long tbBookstoreOrderTbscBookId;

    private Integer tbBookstoreOrderTbscBookCount;

    private Date tbBookstoreOrderTbscCreateTime;

    private Date tbBookstoreOrderTbscUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTbBookstoreOrderTbscBookId() {
        return tbBookstoreOrderTbscBookId;
    }

    public void setTbBookstoreOrderTbscBookId(Long tbBookstoreOrderTbscBookId) {
        this.tbBookstoreOrderTbscBookId = tbBookstoreOrderTbscBookId;
    }

    public Integer getTbBookstoreOrderTbscBookCount() {
        return tbBookstoreOrderTbscBookCount;
    }

    public void setTbBookstoreOrderTbscBookCount(Integer tbBookstoreOrderTbscBookCount) {
        this.tbBookstoreOrderTbscBookCount = tbBookstoreOrderTbscBookCount;
    }

    public Date getTbBookstoreOrderTbscCreateTime() {
        return tbBookstoreOrderTbscCreateTime;
    }

    public void setTbBookstoreOrderTbscCreateTime(Date tbBookstoreOrderTbscCreateTime) {
        this.tbBookstoreOrderTbscCreateTime = tbBookstoreOrderTbscCreateTime;
    }

    public Date getTbBookstoreOrderTbscUpdateTime() {
        return tbBookstoreOrderTbscUpdateTime;
    }

    public void setTbBookstoreOrderTbscUpdateTime(Date tbBookstoreOrderTbscUpdateTime) {
        this.tbBookstoreOrderTbscUpdateTime = tbBookstoreOrderTbscUpdateTime;
    }
}