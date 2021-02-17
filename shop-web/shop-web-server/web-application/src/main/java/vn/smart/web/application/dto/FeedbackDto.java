package vn.smart.web.application.dto;

import vn.smart.web.infrastructure.constants.ValidateMessage;

import javax.validation.constraints.NotEmpty;

public class FeedbackDto {

    @NotEmpty(message = ValidateMessage.REQUIRED)
    private String email;
    @NotEmpty(message = ValidateMessage.REQUIRED)
    private String content;

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
