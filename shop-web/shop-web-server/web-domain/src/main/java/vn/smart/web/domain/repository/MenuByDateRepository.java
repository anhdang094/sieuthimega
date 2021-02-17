package vn.smart.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.smart.web.domain.model.MenuByDay;

public interface MenuByDateRepository extends JpaRepository<MenuByDay, Integer> {

}
