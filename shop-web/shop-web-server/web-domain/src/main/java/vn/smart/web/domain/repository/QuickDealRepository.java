package vn.smart.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smart.web.domain.model.QuickDeal;

@Repository
public interface QuickDealRepository extends JpaRepository<QuickDeal, Integer> {

}
