package vn.smart.admin.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.smart.admin.domain.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
