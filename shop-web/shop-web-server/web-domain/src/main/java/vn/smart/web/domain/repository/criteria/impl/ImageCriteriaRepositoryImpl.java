package vn.smart.web.domain.repository.criteria.impl;

import org.springframework.stereotype.Repository;
import vn.smart.web.domain.repository.criteria.GenericDomainRepository;
import vn.smart.web.domain.repository.criteria.ImageCriteriaRepository;

/**
 * NOTI: This image criteria is used because image data is very large, we not use it because perfomance
 */
@Repository
public class ImageCriteriaRepositoryImpl extends GenericDomainRepository implements ImageCriteriaRepository {

}
