package vn.smart.web.domain.repository.criteria;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDomainRepository<T> {

  @Autowired
  protected EntityManager em;

}
