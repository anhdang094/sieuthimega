package vn.smart.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smart.web.domain.model.Ads;
import vn.smart.web.domain.model.Collection;

import java.util.List;

/**
 * Only use it for get full data from image, in another use image criteria
 */
@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer> {

}
