package vn.smart.web.domain.model.menu;

import vn.smart.web.domain.annotation.DomainEntity;
import vn.smart.web.domain.model.GenericEntity;
import vn.smart.web.domain.model.Product;

import javax.persistence.*;

@DomainEntity
@Entity
@Table(name = "Camera_Product")
public class Camera extends GenericEntity {

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
