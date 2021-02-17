package vn.smart.web.application.service;

import org.springframework.data.domain.Page;
import vn.smart.web.domain.model.Product;
import vn.smart.web.domain.model.ProductInfo;

import java.util.List;

public interface ProductService {

    ProductInfo findProductInfo(int productId);

    Page<Product> getProductOfMerchantsByMerchantId(long merchantId, int page, int pageSize);

    List<Product> getProductSuggesstion(String productIds);

    List<Product> getProductForSearchByFilter(String name);

    Product getProductById(int productId);

}
