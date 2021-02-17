package vn.smart.admin.application.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smart.admin.domain.model.MenuByDay;
import vn.smart.admin.domain.repository.MenuByDateRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class MenuByDateCache {

    private static final Logger _logger = LoggerFactory.getLogger(MenuByDateCache.class);
    private static final String menuByDateKey = "menubydate";

    @Autowired
    private MenuByDateRepository menuByDateRepository;

    private LoadingCache<String, List<MenuByDay>> menuByDateCacheLoader = CacheBuilder.newBuilder()
            .expireAfterWrite(30, TimeUnit.DAYS).build(new CacheLoader<String, List<MenuByDay>>() {
                @Override
                public List<MenuByDay> load(String s) {
                    return menuByDateRepository.findAll();
                }
            });

    public List<MenuByDay> getAllMenuByDate() {
        try {
            return menuByDateCacheLoader.get(menuByDateKey);
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
        }
        return null;
    }

}
