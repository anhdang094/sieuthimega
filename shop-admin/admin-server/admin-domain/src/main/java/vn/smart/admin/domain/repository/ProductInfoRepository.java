package vn.smart.admin.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.smart.admin.domain.model.ProductInfo;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {

}
