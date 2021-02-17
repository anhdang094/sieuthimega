package vn.smart.web.application.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smart.web.domain.model.Ads;
import vn.smart.web.domain.repository.AdsRepository;
import vn.smart.web.infrastructure.enumeration.AdsPosition;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class AdsCache {

    private static final Logger _logger = LoggerFactory.getLogger(AdsCache.class);

    private static final String ADS_KEY = "ADS";

    @Autowired
    private AdsRepository adsRepository;

    private LoadingCache<String, List<Ads>> adsCacheLoader = CacheBuilder.newBuilder()
            .expireAfterWrite(30, TimeUnit.DAYS).build(new CacheLoader<String, List<Ads>>() {
                @Override
                public List<Ads> load(String s) {
                    return adsRepository.findAll();
                }
            });

    public List<Ads> findAllHeaderPosition(AdsPosition adsPosition) {
        try {
            return adsCacheLoader.get(ADS_KEY).stream().filter(item -> item.getPosition() == adsPosition.getCode())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
        }
        return null;
    }
}
