package vn.smart.web.application.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smart.web.domain.model.BestBuy;
import vn.smart.web.domain.repository.BestBuyRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class BestBuyCache {

    private static final Logger _logger = LoggerFactory.getLogger(BestBuyCache.class);

    private static final String BESTBUY_KEY = "BEST_BUY";

    @Autowired
    private BestBuyRepository bestBuyRepository;

    private LoadingCache<String, List<BestBuy>> bestBuyCacheLoader = CacheBuilder.newBuilder()
            .expireAfterWrite(30, TimeUnit.DAYS).build(new CacheLoader<String, List<BestBuy>>() {
                @Override
                public List<BestBuy> load(String s) {
                    return bestBuyRepository.findAll();
                }
            });

    public List<BestBuy> getAllBestBuy() {
        try {
            return bestBuyCacheLoader.get(BESTBUY_KEY);
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
        }
        return null;
    }

}
