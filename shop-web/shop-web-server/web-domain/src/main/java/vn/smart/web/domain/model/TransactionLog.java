package vn.smart.web.domain.model;

import org.springframework.data.annotation.CreatedDate;
import vn.smart.web.domain.annotation.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@DomainEntity
@Entity
@Table(name = "TransactionLog")
public class TransactionLog extends GenericEntity {

    @Column(name = "productId")
    private Long productId;

    @Column(name = "merchantId")
    private Long merchantId;

    @Column(name = "cost")
    private Long cost;

    @Column(name = "fee")
    private Long fee;

    @Column(name = "deliveryFee")
    private Long deliveryFee;

    @Column(name = "customerAddress")
    private String customerAddress;

    @Column(name = "customerPhone")
    private String customerPhone;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "step")
    private Integer step;

    @Column(name = "createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    public TransactionLog() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Long getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Long deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
