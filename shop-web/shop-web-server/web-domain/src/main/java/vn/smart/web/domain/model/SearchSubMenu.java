package vn.smart.web.domain.model;

import vn.smart.web.domain.annotation.DomainEntity;

import javax.persistence.*;

@DomainEntity
@Entity
@Table(name = "Search_SubMenu")
public class SearchSubMenu extends GenericEntity {

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "count")
    private Integer count;

    @ManyToOne
    @JoinColumn(name="searchId", nullable=false)
    private Search search;

    public SearchSubMenu() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
