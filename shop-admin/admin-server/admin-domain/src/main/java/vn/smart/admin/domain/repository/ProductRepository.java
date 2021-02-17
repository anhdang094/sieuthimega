package vn.smart.admin.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.smart.admin.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
