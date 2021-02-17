package vn.smart.web.application.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smart.web.domain.model.Menu;
import vn.smart.web.domain.repository.MenuRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class MenuCache {

    private static final Logger _logger = LoggerFactory.getLogger(MenuCache.class);

    private static final String MENU_KEY = "MENU";

    @Autowired
    private MenuRepository menuRepository;

    private LoadingCache<String, List<Menu>> menuCacheLoader = CacheBuilder.newBuilder()
            .expireAfterWrite(30, TimeUnit.DAYS).build(new CacheLoader<String, List<Menu>>() {
                @Override
                public List<Menu> load(String s) {
                    return menuRepository.findAll();
                }
            });

    public List<Menu> getAllMenu() {
        try {
            return menuCacheLoader.get(MENU_KEY);
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
        }
        return null;
    }

}
