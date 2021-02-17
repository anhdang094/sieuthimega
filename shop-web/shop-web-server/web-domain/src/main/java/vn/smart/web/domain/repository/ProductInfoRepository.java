package vn.smart.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smart.web.domain.model.Product;
import vn.smart.web.domain.model.ProductInfo;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {

    ProductInfo findProductInfoByProductId(int productId);

}
