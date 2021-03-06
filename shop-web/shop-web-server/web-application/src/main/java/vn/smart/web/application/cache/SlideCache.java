package vn.smart.web.application.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smart.web.domain.model.Slide;
import vn.smart.web.domain.repository.SlideRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class SlideCache {

    private static final Logger _logger = LoggerFactory.getLogger(SlideCache.class);

    private static final String SLIDE_KEY = "SLIDE";

    @Autowired
    private SlideRepository slideRepository;

    private LoadingCache<String, List<Slide>> slideCacheLoader = CacheBuilder.newBuilder()
            .expireAfterWrite(30, TimeUnit.DAYS).build(new CacheLoader<String, List<Slide>>() {
                @Override
                public List<Slide> load(String s) {
                    return slideRepository.findAll();
                }
            });

    public List<Slide> getAllSlide() {
        try {
            return slideCacheLoader.get(SLIDE_KEY);
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
        }
        return null;
    }

}
