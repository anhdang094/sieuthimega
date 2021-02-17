package vn.smart.web.domain.model;

import vn.smart.web.domain.annotation.DomainEntity;

import javax.persistence.*;

@DomainEntity
@Entity
@Table(name = "HomeBasicProduct")
public class HomeBasicProduct extends GenericEntity {

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "type")
    private int type;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
