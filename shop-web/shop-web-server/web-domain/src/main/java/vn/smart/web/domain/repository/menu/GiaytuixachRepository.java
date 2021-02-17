package vn.smart.web.domain.repository.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smart.web.domain.model.menu.GiayTuixach;

/**
 * @author anhdx
 */
@Repository
public interface GiaytuixachRepository extends JpaRepository<GiayTuixach, Integer> {

}
