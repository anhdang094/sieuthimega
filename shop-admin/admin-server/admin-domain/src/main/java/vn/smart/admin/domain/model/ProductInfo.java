package vn.smart.admin.domain.model;

import vn.smart.admin.domain.annotation.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DomainEntity
@Entity
@Table(name = "ProductInfo")
public class ProductInfo extends GenericEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "menuType")
    private String menuType;

    @Column(name = "baseCost")
    private long baseCost;

    @Column(name = "cost")
    private long cost;

    @Column(name = "merchantId")
    private int merchantId;

    @Column(name = "companyPhone")
    private String companyPhone;

    @Column(name = "maintanceDay")
    private int maintanceDay;

    @Column(name = "maintanceAddress")
    private String maintanceAddress;

    @Column(name = "specialContent")
    private String specialContent;

    @Column(name = "content")
    private String content;

    @Column(name = "information")
    private String information;

    @Column(name = "suggest")
    private String suggest;

    @Column(name = "productId")
    private int productId;

    @Column(name = "imageIds")
    private String imageIds;

    @Column(name = "sell")
    private Integer sell;

    public ProductInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public long getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(long baseCost) {
        this.baseCost = baseCost;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public int getMaintanceDay() {
        return maintanceDay;
    }

    public void setMaintanceDay(int maintanceDay) {
        this.maintanceDay = maintanceDay;
    }

    public String getMaintanceAddress() {
        return maintanceAddress;
    }

    public void setMaintanceAddress(String maintanceAddress) {
        this.maintanceAddress = maintanceAddress;
    }

    public String getSpecialContent() {
        return specialContent;
    }

    public void setSpecialContent(String specialContent) {
        this.specialContent = specialContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImageIds() {
        return imageIds;
    }

    public void setImageIds(String imageIds) {
        this.imageIds = imageIds;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }
}
