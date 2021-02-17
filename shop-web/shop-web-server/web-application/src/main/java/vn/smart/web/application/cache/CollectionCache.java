package vn.smart.web.application.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smart.web.domain.model.Ads;
import vn.smart.web.domain.model.Collection;
import vn.smart.web.domain.repository.CollectionRepository;
import vn.smart.web.infrastructure.enumeration.AdsPosition;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class CollectionCache {

    private static final Logger _logger = LoggerFactory.getLogger(CollectionCache.class);

    private static final String COLLECTION_KEY = "COLLECTION";

    @Autowired
    private CollectionRepository collectionRepository;

    private LoadingCache<String, List<Collection>> collectionCacheLoader = CacheBuilder.newBuilder()
            .expireAfterWrite(30, TimeUnit.DAYS).build(new CacheLoader<String, List<Collection>>() {
                @Override
                public List<Collection> load(String s) {
                    return collectionRepository.findAll();
                }
            });

    public List<Collection> findAll() {
        try {
            return collectionCacheLoader.get(COLLECTION_KEY);
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
        }
        return null;
    }

}
