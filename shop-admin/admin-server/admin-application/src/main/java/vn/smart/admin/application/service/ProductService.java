package vn.smart.admin.application.service;

import org.springframework.stereotype.Service;
import vn.smart.admin.application.dto.ProductDto;

@Service
public interface ProductService {

    int registerProduct(ProductDto productDto);
}
