package vn.smart.admin.domain.model;

import vn.smart.admin.domain.annotation.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DomainEntity
@Entity
@Table(name = "Slide")
public class Slide extends GenericEntity {

    @Column(name = "header_large")
    private String headerLarge;

    @Column(name = "header_normal")
    private String headerNormal;

    @Column(name = "content")
    private String content;

    @Column(name = "url")
    private String url;

    @Column(name = "imageId")
    private int imageId;

    public Slide() {
    }

    public String getHeaderLarge() {
        return headerLarge;
    }

    public void setHeaderLarge(String headerLarge) {
        this.headerLarge = headerLarge;
    }

    public String getHeaderNormal() {
        return headerNormal;
    }

    public void setHeaderNormal(String headerNormal) {
        this.headerNormal = headerNormal;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
