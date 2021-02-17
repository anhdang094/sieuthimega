package vn.smart.web.application.factory;

import vn.smart.web.domain.model.Feedback;

public final class FeedbackFactory {

    private FeedbackFactory() {
    }

    public static Feedback generateNewFeeback(String email, String content) {
        Feedback feedback = new Feedback();
        feedback.setEmail(email);
        feedback.setContent(content);
        return feedback;
    }

}
