package vn.smart.web.domain.repository.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smart.web.domain.model.menu.MevaBe;

/**
 * @author anhdx
 */
@Repository
public interface MevaBeRepository extends JpaRepository<MevaBe, Integer> {

}
