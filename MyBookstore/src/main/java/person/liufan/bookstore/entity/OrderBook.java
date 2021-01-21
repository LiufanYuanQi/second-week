package person.liufan.bookstore.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderBook {
    private Long id;

    private String tbBookstoreBookName;

    private String tbBookstoreBookAuthor;

    private String tbBookstoreBookPublishing;

    private BigDecimal tbBookstoreBookPrice;

    private Integer tbBookstoreBookNumber;

    private String tbBookstoreBookInfo;

    private String tbBookstoreBookPictureUrl;

    private Date tbBookstoreBookCreateTime;

    private Date tbBookstoreBookUpdateTime;

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

    public Date getTbBookstoreBookCreateTime() {
        return tbBookstoreBookCreateTime;
    }

    public void setTbBookstoreBookCreateTime(Date tbBookstoreBookCreateTime) {
        this.tbBookstoreBookCreateTime = tbBookstoreBookCreateTime;
    }

    public Date getTbBookstoreBookUpdateTime() {
        return tbBookstoreBookUpdateTime;
    }

    public void setTbBookstoreBookUpdateTime(Date tbBookstoreBookUpdateTime) {
        this.tbBookstoreBookUpdateTime = tbBookstoreBookUpdateTime;
    }
}