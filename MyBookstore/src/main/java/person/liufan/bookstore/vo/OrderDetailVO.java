package person.liufan.bookstore.vo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/21
 * 查询订单需要返回的参数
 * 一个cartVO数组，购买时候的信息
 * 总金额
 * 下单时间，创建时间
 * 收货地址
 * 订单号
 */
public class OrderDetailVO {
    /**
     * 订单id
     */
    private Long id;
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
    private String tbBookstoreOrderCreateTime;
    /**
     * 订单中的购物详情
     */
    private List<CartVO> cartVOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTbBookstoreOrderCreateTime() {
        return tbBookstoreOrderCreateTime;
    }

    public void setTbBookstoreOrderCreateTime(String tbBookstoreOrderCreateTime) {
        this.tbBookstoreOrderCreateTime = tbBookstoreOrderCreateTime;
    }

    public List<CartVO> getCartVOS() {
        return cartVOS;
    }

    public void setCartVOS(List<CartVO> cartVOS) {
        this.cartVOS = cartVOS;
    }

    @Override
    public String toString() {
        return "OrderDetailVO{" +
                "id=" + id +
                ", tbBookstoreOrderTotalMoney=" + tbBookstoreOrderTotalMoney +
                ", tbBookstoreOrderShippingAddress='" + tbBookstoreOrderShippingAddress + '\'' +
                ", tbBookstoreOrderCreateTime='" + tbBookstoreOrderCreateTime + '\'' +
                ", cartVOS=" + cartVOS +
                '}';
    }
}
