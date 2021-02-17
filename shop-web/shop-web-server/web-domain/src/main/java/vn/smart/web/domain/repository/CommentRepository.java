package vn.smart.web.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.smart.web.domain.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Page<Comment> findAllByProductId(int productId, Pageable pageable);

}
