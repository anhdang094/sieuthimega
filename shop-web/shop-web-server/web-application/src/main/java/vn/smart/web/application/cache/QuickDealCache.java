package vn.smart.web.application.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smart.web.domain.model.QuickDeal;
import vn.smart.web.domain.repository.QuickDealRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class QuickDealCache {

    private static final Logger _logger = LoggerFactory.getLogger(QuickDealCache.class);

    private static final String QUICK_DEL_KEY = "QUICK_DEAL";

    @Autowired
    private QuickDealRepository quickDealRepository;

    private LoadingCache<String, List<QuickDeal>> quickdealCacheLoader = CacheBuilder.newBuilder()
            .expireAfterWrite(30, TimeUnit.DAYS).build(new CacheLoader<String, List<QuickDeal>>() {
                @Override
                public List<QuickDeal> load(String s) {
                    return quickDealRepository.findAll();
                }
            });

    public List<QuickDeal> findAll() {
        try {
            return quickdealCacheLoader.get(QUICK_DEL_KEY);
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
        }
        return null;
    }
}
