package vn.smart.admin.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smart.admin.domain.model.Image;
import vn.smart.admin.domain.repository.criteria.ImageCriteriaRepository;

/**
 * Only use it for get full data from image, in another use image criteria
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>, ImageCriteriaRepository {

    Image findAllById(int id);
}
