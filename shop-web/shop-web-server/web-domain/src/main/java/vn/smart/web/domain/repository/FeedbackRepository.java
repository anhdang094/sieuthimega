package vn.smart.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.smart.web.domain.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
