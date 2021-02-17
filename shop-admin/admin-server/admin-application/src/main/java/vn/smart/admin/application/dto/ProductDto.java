package vn.smart.admin.application.dto;

import io.swagger.models.auth.In;

public class ProductDto {

    private String name;
    private String title;
    private String description;
    private String brand;
    private String menuType;
    private Long baseCost;
    private Long cost;
    private Integer merchantId;
    private String companyPhone;
    private Integer maintanceDay;
    private String maintanceAddress;
    private String specialContent;
    private String content;
    private String information;
    private String suggest;
    private String imageIds;
    private Integer code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(Long baseCost) {
        this.baseCost = baseCost;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public Integer getMaintanceDay() {
        return maintanceDay;
    }

    public void setMaintanceDay(Integer maintanceDay) {
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

    public String getImageIds() {
        return imageIds;
    }

    public void setImageIds(String imageIds) {
        this.imageIds = imageIds;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
