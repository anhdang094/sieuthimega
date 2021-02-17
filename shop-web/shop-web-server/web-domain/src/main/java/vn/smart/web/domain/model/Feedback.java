package vn.smart.web.domain.model;

import vn.smart.web.domain.annotation.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DomainEntity
@Entity
@Table(name = "Feedback")
public class Feedback extends GenericEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "content")
    private String content;

    public Feedback() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
