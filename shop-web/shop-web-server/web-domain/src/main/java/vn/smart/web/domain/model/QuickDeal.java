package vn.smart.web.domain.model;

import vn.smart.web.domain.annotation.DomainEntity;

import javax.persistence.*;

@DomainEntity
@Entity
@Table(name = "Quickdeal")
public class QuickDeal extends GenericEntity {

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
