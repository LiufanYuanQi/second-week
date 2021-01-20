package person.liufan.bookstore.vo;

import java.math.BigDecimal;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/20
 */
public class CartVO {
    private Long id;
    private String tbBookstoreBookName;
    private BigDecimal tbBookstoreBookPrice;
    private Integer tbBookstoreShoppingCartBookCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTbBookstoreBookName() {
        return tbBookstoreBookName;
    }

    public void setTbBookstoreBookName(String tbBookstoreBookName) {
        this.tbBookstoreBookName = tbBookstoreBookName;
    }

    public BigDecimal getTbBookstoreBookPrice() {
        return tbBookstoreBookPrice;
    }

    public void setTbBookstoreBookPrice(BigDecimal tbBookstoreBookPrice) {
        this.tbBookstoreBookPrice = tbBookstoreBookPrice;
    }

    public Integer getTbBookstoreShoppingCartBookCount() {
        return tbBookstoreShoppingCartBookCount;
    }

    public void setTbBookstoreShoppingCartBookCount(Integer tbBookstoreShoppingCartBookCount) {
        this.tbBookstoreShoppingCartBookCount = tbBookstoreShoppingCartBookCount;
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "id=" + id +
                ", tbBookstoreBookName='" + tbBookstoreBookName + '\'' +
                ", tbBookstoreBookPrice=" + tbBookstoreBookPrice +
                ", tbBookstoreShoppingCartBookCount=" + tbBookstoreShoppingCartBookCount +
                '}';
    }
}
