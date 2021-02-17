package vn.smart.web.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smart.web.domain.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAllByMerchantId(long merchantId, Pageable pageable);

    List<Product> findAllByIdIn(List<Integer> productIds);

    Page<Product> findAllByTitleContains(String name, Pageable pageable);

    Product findFirstById(Integer productId);

}
