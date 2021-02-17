package vn.smart.admin.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.smart.admin.application.dto.ProductDto;
import vn.smart.admin.application.service.ProductService;
import vn.smart.admin.domain.model.Product;
import vn.smart.admin.domain.model.ProductInfo;
import vn.smart.admin.domain.repository.ProductInfoRepository;
import vn.smart.admin.domain.repository.ProductRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public int registerProduct(ProductDto productDto) {
        Product product = new Product();
        product.setCost(productDto.getCost());
        product.setDescription(productDto.getDescription());
        product.setImageId(productDto.getImageIds().split(",")[0]);
        product.setMenuType(productDto.getMenuType());
        product.setMerchantId(productDto.getMerchantId());
        product.setTitle(productDto.getTitle());
        int productId = productRepository.save(product).getId();
        ProductInfo productInfo = new ProductInfo();
        productInfo.setBaseCost(productDto.getBaseCost());
        productInfo.setBrand(productDto.getBrand());
        productInfo.setCompanyPhone(productDto.getCompanyPhone());
        productInfo.setContent(productDto.getContent());
        productInfo.setCost(productDto.getCost());
        productInfo.setImageIds(productDto.getImageIds());
        productInfo.setInformation(productDto.getInformation());
        productInfo.setMaintanceAddress(productDto.getMaintanceAddress());
        productInfo.setMaintanceDay(productDto.getMaintanceDay());
        productInfo.setMenuType(productDto.getMenuType());
        productInfo.setMerchantId(productDto.getMerchantId());
        productInfo.setName(productDto.getName());
        productInfo.setProductId(productId);
        productInfo.setSell(1);
        productInfo.setSpecialContent(productDto.getSpecialContent());
        productInfo.setSuggest(productDto.getSuggest());
        return productInfoRepository.save(productInfo).getId();
    }
}
