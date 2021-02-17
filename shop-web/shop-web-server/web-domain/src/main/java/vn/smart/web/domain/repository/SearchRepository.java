package vn.smart.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.smart.web.domain.model.Search;

public interface SearchRepository extends JpaRepository<Search, Integer> {

}
