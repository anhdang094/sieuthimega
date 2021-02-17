package vn.smart.web.application.service;

import vn.smart.web.domain.model.Image;

import java.util.List;

public interface ImageService {

    /**
     * getImageById
     * @param imageId
     * @param isCache
     * @return
     */
    Image getImageById(int imageId, boolean isCache);

    /**
     * loadImageAdsHeader
     * @param type
     * @return
     */
    List<Integer> loadImageAdsHeader(Integer type);

}
