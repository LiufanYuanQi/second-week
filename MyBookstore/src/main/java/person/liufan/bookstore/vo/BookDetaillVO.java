package person.liufan.bookstore.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/20
 */
public class BookDetaillVO {
    private Long id;

    private String tbBookstoreBookName;

    private String tbBookstoreBookAuthor;

    private String tbBookstoreBookPublishing;

    private BigDecimal tbBookstoreBookPrice;

    private Integer tbBookstoreBookNumber;

    private String tbBookstoreBookInfo;

    private String tbBookstoreBookPictureUrl;

    private String tbBookstoreBookCreateTime;

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

    public String getTbBookstoreBookAuthor() {
        return tbBookstoreBookAuthor;
    }

    public void setTbBookstoreBookAuthor(String tbBookstoreBookAuthor) {
        this.tbBookstoreBookAuthor = tbBookstoreBookAuthor;
    }

    public String getTbBookstoreBookPublishing() {
        return tbBookstoreBookPublishing;
    }

    public void setTbBookstoreBookPublishing(String tbBookstoreBookPublishing) {
        this.tbBookstoreBookPublishing = tbBookstoreBookPublishing;
    }

    public BigDecimal getTbBookstoreBookPrice() {
        return tbBookstoreBookPrice;
    }

    public void setTbBookstoreBookPrice(BigDecimal tbBookstoreBookPrice) {
        this.tbBookstoreBookPrice = tbBookstoreBookPrice;
    }

    public Integer getTbBookstoreBookNumber() {
        return tbBookstoreBookNumber;
    }

    public void setTbBookstoreBookNumber(Integer tbBookstoreBookNumber) {
        this.tbBookstoreBookNumber = tbBookstoreBookNumber;
    }

    public String getTbBookstoreBookInfo() {
        return tbBookstoreBookInfo;
    }

    public void setTbBookstoreBookInfo(String tbBookstoreBookInfo) {
        this.tbBookstoreBookInfo = tbBookstoreBookInfo;
    }

    public String getTbBookstoreBookPictureUrl() {
        return tbBookstoreBookPictureUrl;
    }

    public void setTbBookstoreBookPictureUrl(String tbBookstoreBookPictureUrl) {
        this.tbBookstoreBookPictureUrl = tbBookstoreBookPictureUrl;
    }

    public String getTbBookstoreBookCreateTime() {
        return tbBookstoreBookCreateTime;
    }

    public void setTbBookstoreBookCreateTime(String tbBookstoreBookCreateTime) {
        this.tbBookstoreBookCreateTime = tbBookstoreBookCreateTime;
    }

    @Override
    public String toString() {
        return "BookDetaillVO{" +
                "id=" + id +
                ", tbBookstoreBookName='" + tbBookstoreBookName + '\'' +
                ", tbBookstoreBookAuthor='" + tbBookstoreBookAuthor + '\'' +
                ", tbBookstoreBookPublishing='" + tbBookstoreBookPublishing + '\'' +
                ", tbBookstoreBookPrice=" + tbBookstoreBookPrice +
                ", tbBookstoreBookNumber=" + tbBookstoreBookNumber +
                ", tbBookstoreBookInfo='" + tbBookstoreBookInfo + '\'' +
                ", tbBookstoreBookPictureUrl='" + tbBookstoreBookPictureUrl + '\'' +
                ", tbBookstoreBookCreateTime='" + tbBookstoreBookCreateTime + '\'' +
                '}';
    }
}
