package vn.smart.web.domain.model;

import vn.smart.web.domain.annotation.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DomainEntity
@Entity
@Table(name = "Merchant")
public class Merchant extends GenericEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "rate")
    private Integer rate;

    @Column(name = "responseRate")
    private Integer responseRate;

    @Column(name = "ontimeDelivery")
    private Integer ontimeDelivery;

    public Merchant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getResponseRate() {
        return responseRate;
    }

    public void setResponseRate(Integer responseRate) {
        this.responseRate = responseRate;
    }

    public Integer getOntimeDelivery() {
        return ontimeDelivery;
    }

    public void setOntimeDelivery(Integer ontimeDelivery) {
        this.ontimeDelivery = ontimeDelivery;
    }
}
