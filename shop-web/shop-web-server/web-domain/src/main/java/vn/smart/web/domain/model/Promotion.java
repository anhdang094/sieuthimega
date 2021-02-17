package vn.smart.web.domain.model;

import vn.smart.web.domain.annotation.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DomainEntity
@Entity
@Table(name = "Promotion")
public class Promotion extends GenericEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "name")
    private String name;

    @Column(name = "fixValue")
    private Long fixValue;

    @Column(name = "percentValue")
    private Long percentValue;

    @Column(name = "imageId")
    private Integer imageId;

    @Column(name = "isActive")
    private Integer isActive;

    public Promotion() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFixValue() {
        return fixValue;
    }

    public void setFixValue(Long fixValue) {
        this.fixValue = fixValue;
    }

    public Long getPercentValue() {
        return percentValue;
    }

    public void setPercentValue(Long percentValue) {
        this.percentValue = percentValue;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}
