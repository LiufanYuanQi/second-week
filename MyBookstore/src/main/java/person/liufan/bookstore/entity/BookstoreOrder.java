package person.liufan.bookstore.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 图书订单实体类
 */
public class BookstoreOrder {
    /**
     * 订单id
     */
    private Long id;
    /**
     * 订单所属用户的id
     */
    private Long tbBookstoreOrderUserId;
    /**
     * 订单的所有金额
     */
    private BigDecimal tbBookstoreOrderTotalMoney;
    /**
     * 订单的收货地址
     */
    private String tbBookstoreOrderShippingAddress;
    /**
     * 创建时间
     */
    private Date tbBookstoreOrderCreateTime;
    /**
     * 更新时间
     */
    private Date tbBookstoreOrderUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTbBookstoreOrderUserId() {
        return tbBookstoreOrderUserId;
    }

    public void setTbBookstoreOrderUserId(Long tbBookstoreOrderUserId) {
        this.tbBookstoreOrderUserId = tbBookstoreOrderUserId;
    }

    public BigDecimal getTbBookstoreOrderTotalMoney() {
        return tbBookstoreOrderTotalMoney;
    }

    public void setTbBookstoreOrderTotalMoney(BigDecimal tbBookstoreOrderTotalMoney) {
        this.tbBookstoreOrderTotalMoney = tbBookstoreOrderTotalMoney;
    }

    public String getTbBookstoreOrderShippingAddress() {
        return tbBookstoreOrderShippingAddress;
    }

    public void setTbBookstoreOrderShippingAddress(String tbBookstoreOrderShippingAddress) {
        this.tbBookstoreOrderShippingAddress = tbBookstoreOrderShippingAddress;
    }

    public Date getTbBookstoreOrderCreateTime() {
        return tbBookstoreOrderCreateTime;
    }

    public void setTbBookstoreOrderCreateTime(Date tbBookstoreOrderCreateTime) {
        this.tbBookstoreOrderCreateTime = tbBookstoreOrderCreateTime;
    }

    public Date getTbBookstoreOrderUpdateTime() {
        return tbBookstoreOrderUpdateTime;
    }

    public void setTbBookstoreOrderUpdateTime(Date tbBookstoreOrderUpdateTime) {
        this.tbBookstoreOrderUpdateTime = tbBookstoreOrderUpdateTime;
    }
}