package vn.smart.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.smart.web.domain.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
