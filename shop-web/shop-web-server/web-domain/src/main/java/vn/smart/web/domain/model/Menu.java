package vn.smart.web.domain.model;

import vn.smart.web.domain.annotation.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DomainEntity
@Entity
@Table(name = "Menu")
public class Menu extends GenericEntity {

    @Column(name = "text")
    private String text;

    @Column(name = "url")
    private String url;

    @Column(name = "icon")
    private String icon;

    public Menu() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
