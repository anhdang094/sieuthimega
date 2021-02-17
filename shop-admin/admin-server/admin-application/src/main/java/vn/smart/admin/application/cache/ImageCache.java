package vn.smart.admin.application.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smart.admin.domain.model.Image;
import vn.smart.admin.domain.repository.ImageRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ImageCache {

    private static final Logger _logger = LoggerFactory.getLogger(ImageCache.class);

    @Autowired
    private ImageRepository imageRepository;

    public Image findByImageId(int id) {
        try {
            return imageRepository.findAllById(id);
        } catch (Exception e) {
            _logger.info("Exception with message: " + e.getMessage());
            return null;
        }
    }

    public Integer saveImage(Image image) {
        return imageRepository.save(image).getId();
    }

    public void saveAllImage(List<Image> images) {
        imageRepository.saveAll(images);
    }

    public Integer deleteImage(int imageID) {
        imageRepository.deleteById(imageID);
        return imageID;
    }


}
