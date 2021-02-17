package vn.smart.web.application.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smart.web.domain.model.Image;
import vn.smart.web.domain.repository.ImageRepository;

import java.util.concurrent.TimeUnit;

@Component
public class ImageCache {

    private static final Logger _logger = LoggerFactory.getLogger(ImageCache.class);

    @Autowired
    private ImageRepository imageRepository;

    private LoadingCache<Integer, Image> imageCacheLoader = CacheBuilder.newBuilder()
            .expireAfterWrite(24, TimeUnit.HOURS).build(new CacheLoader<Integer, Image>() {
                @Override
                public Image load(Integer id) {
                    return imageRepository.findAllById(id);
                }
            });

    public Image findByImageId(int id) {
        try {
            return imageRepository.findAllById(id);
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
            return null;
        }
    }

    public Image findByImageIdWithCache(int id) {
        try {
            return imageCacheLoader.get(id);
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
            return null;
        }
    }

}
