package vn.smart.web.domain.model;

import vn.smart.web.domain.annotation.DomainEntity;

import javax.persistence.*;
import java.util.Set;

@DomainEntity
@Entity
@Table(name = "Search")
public class Search extends GenericEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy="search", fetch = FetchType.EAGER)
    private Set<SearchSubMenu> searchSubMenus;

    public Search() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<SearchSubMenu> getSearchSubMenus() {
        return searchSubMenus;
    }

    public void setSearchSubMenus(Set<SearchSubMenu> searchSubMenus) {
        this.searchSubMenus = searchSubMenus;
    }
}
