package vn.smart.web.domain.repository.menu;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smart.web.domain.model.menu.ThietBiDienTu;

/**
 * @author anhdx
 */
@Repository
public interface ThietBiDienTuRepository extends JpaRepository<ThietBiDienTu, Integer> {

}
