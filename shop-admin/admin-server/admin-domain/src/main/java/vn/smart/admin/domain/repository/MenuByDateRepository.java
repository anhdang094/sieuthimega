package vn.smart.admin.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.smart.admin.domain.model.MenuByDay;

public interface MenuByDateRepository extends JpaRepository<MenuByDay, Integer> {

}
