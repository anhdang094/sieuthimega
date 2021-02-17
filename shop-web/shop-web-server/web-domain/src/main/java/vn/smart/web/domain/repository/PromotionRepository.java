package vn.smart.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smart.web.domain.model.Promotion;

import java.util.List;

/**
 * Only use it for get full data from image, in another use image criteria
 */
@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    List<Promotion> findAllByIsActive(int activeValue);

}
