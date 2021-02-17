package vn.smart.web.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.smart.web.application.service.ProductService;
import vn.smart.web.domain.model.Comment;
import vn.smart.web.domain.model.Product;
import vn.smart.web.domain.model.ProductInfo;
import vn.smart.web.domain.repository.CommentRepository;
import vn.smart.web.domain.repository.ProductInfoRepository;
import vn.smart.web.domain.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductSuggesstion(String productIds) {
        return productRepository.findAllByIdIn(Arrays.stream(productIds.split(","))
                .map(item -> Integer.valueOf(item)).collect(Collectors.toList()));
    }

    @Override
    public List<Product> getProductForSearchByFilter(String name) {
        Pageable pageable = PageRequest.of(0, 8);
        return productRepository.findAllByTitleContains(name, pageable).getContent();
    }

    @Override
    public Product getProductById(int productId) {
        return productRepository.findFirstById(productId);
    }

    @Override
    public ProductInfo findProductInfo(int productId) {
        return productInfoRepository.findProductInfoByProductId(productId);
    }

    @Override
    public Page<Product> getProductOfMerchantsByMerchantId(long merchantId, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return productRepository.findAllByMerchantId(merchantId, pageable);
    }
}
