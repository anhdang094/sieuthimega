package vn.smart.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smart.web.domain.model.Image;
import vn.smart.web.domain.repository.criteria.ImageCriteriaRepository;

import java.util.List;

/**
 * Only use it for get full data from image, in another use image criteria
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>, ImageCriteriaRepository {

    Image findAllById(int id);

    List<Image> findAllByIdIn(List<Integer> ids);
}
