package person.liufan.bookstore.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 图书实体类
 */
public class BookstoreBook {
    /**
     * 记录id
     */
    private Long id;
    /**
     * 图书名字
     */
    private String tbBookstoreBookName;
    /**
     * 图书作者
     */
    private String tbBookstoreBookAuthor;
    /**
     * 图书出版社
     */
    private String tbBookstoreBookPublishing;
    /**
     * 图书价格
     */
    private BigDecimal tbBookstoreBookPrice;
    /**
     * 图书数量
     */
    private Integer tbBookstoreBookNumber;
    /**
     * 图书介绍信息
     */
    private String tbBookstoreBookInfo;
    /**
     * 图书介绍图片url
     */
    private String tbBookstoreBookPictureUrl;
    /**
     * 创建时间
     */
    private Date tbBookstoreBookCreateTime;
    /**
     * 更新时间
     */
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