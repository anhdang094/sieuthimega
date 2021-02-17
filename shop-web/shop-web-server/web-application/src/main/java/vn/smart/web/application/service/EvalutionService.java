package vn.smart.web.application.service;

import org.springframework.data.domain.Page;
import vn.smart.web.domain.model.Comment;
import vn.smart.web.domain.model.Product;
import vn.smart.web.domain.model.ProductInfo;

import java.util.List;

public interface EvalutionService {

    Page<Comment> getAllCommentByProductId(int productId, int page, int pageSize);

    void postFeedBack(String email, String feedback);

}
