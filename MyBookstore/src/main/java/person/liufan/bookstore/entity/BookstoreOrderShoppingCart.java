package person.liufan.bookstore.entity;

import java.util.Date;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 订单关联商品id实体类
 */
public class BookstoreOrderShoppingCart {
    /**
     * 订单关联的商品id
     */
    private Long id;
    /**
     * 关联的订单id
     */
    private Long tbBookstoreOrderTbscOrderId;
    /**
     * 该订单中存在的图书id
     */
    private Long tbBookstoreOrderTbscBookId;
    /**
     * 该订单中存在的图书总数
     */
    private Integer tbBookstoreOrderTbscBookCount;
    /**
     * 创建时间
     */
    private Date tbBookstoreOrderTbscCreateTime;
    /**
     * 修改时间
     */
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

    public Long getTbBookstoreOrderTbscOrderId() {
        return tbBookstoreOrderTbscOrderId;
    }

    public void setTbBookstoreOrderTbscOrderId(Long tbBookstoreOrderTbscOrderId) {
        this.tbBookstoreOrderTbscOrderId = tbBookstoreOrderTbscOrderId;
    }
}