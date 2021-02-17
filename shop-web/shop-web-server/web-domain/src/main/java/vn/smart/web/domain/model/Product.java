package vn.smart.web.domain.model;

import vn.smart.web.domain.annotation.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DomainEntity
@Entity
@Table(name = "Product")
public class Product extends GenericEntity {

    @Column(name = "imageId")
    private Integer imageId;

    @Column(name = "cost")
    private long cost;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;

    @Column(name = "menuType")
    private String menuType;

    @Column(name = "merchantId")
    private long merchantId;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }
}
