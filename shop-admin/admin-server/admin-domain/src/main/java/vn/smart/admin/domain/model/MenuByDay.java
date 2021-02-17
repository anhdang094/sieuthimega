package vn.smart.admin.domain.model;

import vn.smart.admin.domain.annotation.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DomainEntity
@Entity
@Table(name = "MenuByDay")
public class MenuByDay extends GenericEntity {

    @Column(name = "text")
    private String text;

    @Column(name = "level")
    private int level;

    @Column(name = "parentId")
    private int parentId;

    @Column(name = "parentUrl")
    private String parentUrl;

    @Column(name = "subUrl")
    private String subUrl;

    public MenuByDay() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentUrl() {
        return parentUrl;
    }

    public void setParentUrl(String parentUrl) {
        this.parentUrl = parentUrl;
    }

    public String getSubUrl() {
        return subUrl;
    }

    public void setSubUrl(String subUrl) {
        this.subUrl = subUrl;
    }
}
