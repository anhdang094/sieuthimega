package vn.smart.web.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.smart.web.application.cache.AdsCache;
import vn.smart.web.application.cache.ImageCache;
import vn.smart.web.application.service.ImageService;
import vn.smart.web.domain.model.Ads;
import vn.smart.web.domain.model.Image;
import vn.smart.web.domain.repository.AdsRepository;
import vn.smart.web.infrastructure.enumeration.AdsPosition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageCache imageCache;

    @Autowired
    private AdsRepository adsRepository;

    @Autowired
    private AdsCache adsCache;

    @Override
    public Image getImageById(int imageId, boolean isCache) {
        if (isCache) {
            return imageCache.findByImageIdWithCache(imageId);
        } else {
            return imageCache.findByImageId(imageId);
        }
    }

    @Override
    public List<Integer> loadImageAdsHeader(Integer type) {
        if (type != null) {
            return adsCache.findAllHeaderPosition(AdsPosition.fromValue(type))
                    .stream().sorted(Comparator.comparingInt(Ads::getNumber)).map(item -> item.getImageId()).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
