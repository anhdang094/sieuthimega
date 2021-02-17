package vn.smart.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smart.web.domain.model.Merchant;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

    Merchant findFirstById(int merchantId);

}
