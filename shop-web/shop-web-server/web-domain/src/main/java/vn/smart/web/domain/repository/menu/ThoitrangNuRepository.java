package vn.smart.web.domain.repository.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smart.web.domain.model.menu.ThoitrangNu;

/**
 * @author anhdx
 */
@Repository
public interface ThoitrangNuRepository extends JpaRepository<ThoitrangNu, Integer> {

}
