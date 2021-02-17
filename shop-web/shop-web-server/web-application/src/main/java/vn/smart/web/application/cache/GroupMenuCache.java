package vn.smart.web.application.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smart.web.domain.model.GroupMenu;
import vn.smart.web.domain.repository.GroupMenuRepository;
import vn.smart.web.infrastructure.enumeration.MenuType;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class GroupMenuCache {

    private static final Logger _logger = LoggerFactory.getLogger(GroupMenuCache.class);

    private static final String GROUP_MENU_KEY = "GROUP_MENU";

    @Autowired
    private GroupMenuRepository groupMenuRepository;

    private LoadingCache<String, List<GroupMenu>> menuGroupCacheLoader = CacheBuilder.newBuilder()
            .expireAfterWrite(30, TimeUnit.DAYS).build(new CacheLoader<String, List<GroupMenu>>() {
                @Override
                public List<GroupMenu> load(String s) {
                    return groupMenuRepository.findAll();
                }
            });

    public List<GroupMenu> findAllByType(MenuType type) {
        try {
            return menuGroupCacheLoader.get(GROUP_MENU_KEY).stream().filter(item -> item.getType() == type.getCode())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
        }
        return null;
    }
}
