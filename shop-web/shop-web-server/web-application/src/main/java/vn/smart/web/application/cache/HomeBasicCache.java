package vn.smart.web.application.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smart.web.domain.model.Collection;
import vn.smart.web.domain.model.HomeBasicProduct;
import vn.smart.web.domain.repository.HomeBasicProductRepository;
import vn.smart.web.infrastructure.enumeration.HomeProductType;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class HomeBasicCache {

    private static final Logger _logger = LoggerFactory.getLogger(HomeBasicCache.class);

    private static final String HOME_BASIC_KEY = "HOME_BASIC";

    @Autowired
    private HomeBasicProductRepository homeBasicProductRepository;

    private LoadingCache<String, List<HomeBasicProduct>> homeBasicCacheLoader = CacheBuilder.newBuilder()
            .expireAfterWrite(30, TimeUnit.DAYS).build(new CacheLoader<String, List<HomeBasicProduct>>() {
                @Override
                public List<HomeBasicProduct> load(String s) {
                    return homeBasicProductRepository.findAll();
                }
            });

    public List<HomeBasicProduct> findAll() {
        try {
            return homeBasicCacheLoader.get(HOME_BASIC_KEY);
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
        }
        return null;
    }

    public List<HomeBasicProduct> findHotProduct() {
        try {
            return homeBasicCacheLoader.get(HOME_BASIC_KEY)
                    .stream().filter(item -> item.getType() == HomeProductType.HOT.getCode()).collect(Collectors.toList());
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
        }
        return null;
    }

    public List<HomeBasicProduct> findBaseProduct() {
        try {
            return homeBasicCacheLoader.get(HOME_BASIC_KEY)
                    .stream().filter(item -> item.getType() == HomeProductType.BASE.getCode()).collect(Collectors.toList());
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
        }
        return null;
    }

    public List<HomeBasicProduct> findForUProduct() {
        try {
            return homeBasicCacheLoader.get(HOME_BASIC_KEY)
                    .stream().filter(item -> item.getType() == HomeProductType.FORYOU.getCode()).collect(Collectors.toList());
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
        }
        return null;
    }

}
