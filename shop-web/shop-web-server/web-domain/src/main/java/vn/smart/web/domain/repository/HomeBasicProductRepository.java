package vn.smart.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smart.web.domain.model.HomeBasicProduct;

/**
 * Only use it for get full data from image, in another use image criteria
 */
@Repository
public interface HomeBasicProductRepository extends JpaRepository<HomeBasicProduct, Integer> {

}
