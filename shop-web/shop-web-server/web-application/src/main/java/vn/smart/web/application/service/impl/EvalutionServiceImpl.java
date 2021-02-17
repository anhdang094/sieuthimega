package vn.smart.web.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.smart.web.application.service.EvalutionService;
import vn.smart.web.domain.model.Comment;
import vn.smart.web.domain.repository.CommentRepository;
import vn.smart.web.domain.repository.FeedbackRepository;

import static vn.smart.web.application.factory.FeedbackFactory.generateNewFeeback;

@Service
public class EvalutionServiceImpl implements EvalutionService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public Page<Comment> getAllCommentByProductId(int productId, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return commentRepository.findAllByProductId(productId, pageable);
    }

    @Override
    public void postFeedBack(String email, String feedback) {
        feedbackRepository.save(generateNewFeeback(email, feedback));
    }
}
