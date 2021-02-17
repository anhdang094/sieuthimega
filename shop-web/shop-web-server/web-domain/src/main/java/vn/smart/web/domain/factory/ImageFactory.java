package vn.smart.web.domain.factory;

import vn.smart.web.domain.model.Image;

import java.time.LocalDateTime;

public final class ImageFactory {

    private ImageFactory() {
    }

    public static Image generateImageModel(String fileName, String displayName, String extension, String contentType) {
        Image image = new Image();
        image.setFileName(fileName);
        image.setDisplayName(displayName);
        image.setExtension(extension);
        image.setCreatedAt(LocalDateTime.now());
        image.setContentType(contentType);
        return image;
    }

}
