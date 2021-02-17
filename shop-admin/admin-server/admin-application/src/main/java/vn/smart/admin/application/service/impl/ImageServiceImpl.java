package vn.smart.admin.application.service.impl;

import com.google.common.io.Closeables;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.smart.admin.application.cache.ImageCache;
import vn.smart.admin.application.service.ImageService;
import vn.smart.admin.domain.model.Image;
import vn.smart.admin.infrastructure.utils.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static vn.smart.admin.domain.factory.ImageFactory.generateImageModel;
import static vn.smart.admin.infrastructure.constants.CommonConstants.MAX_IMAGE_NAME;

@Service
public class ImageServiceImpl implements ImageService {

    protected static Logger _logger = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    private ImageCache imageCache;

    @Override
    public Image getImageById(int imageId) {
        return imageCache.findByImageId(imageId);
    }

    @Override
    public Integer uploadImage(MultipartFile uploadFile) {
        InputStream inputStream = null;
        try {
            String fileName = StringUtils.truncateToLength(FilenameUtils.getBaseName(uploadFile.getOriginalFilename()), MAX_IMAGE_NAME);
            String displayName =
                    StringUtils.truncateToLength(FilenameUtils.getBaseName(uploadFile.getOriginalFilename()), MAX_IMAGE_NAME) + "." + FilenameUtils
                            .getExtension(uploadFile.getOriginalFilename());
            inputStream = uploadFile.getInputStream();
            return imageCache.saveImage(
                    streamImage(inputStream,
                            fileName,
                            displayName,
                            FilenameUtils.getExtension(displayName),
                            uploadFile.getContentType()));
        } catch (IOException e) {
            _logger.error("Exception upload image " + e.getMessage());
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Closeables.closeQuietly(inputStream);
                }
            }
        }
    }

    @Override
    public boolean deleteImage(String imageID) {
        try {
            imageCache.deleteImage(Integer.valueOf(imageID));
            return true;
        } catch (Exception e) {
            _logger.error("Exception delete image " + e.getMessage());
            return false;
        }
    }

    private Image streamImage(InputStream fileStream, String fileName, String displayName, String extension, String contentType) throws IOException {
        Image image = generateImageModel(fileName, displayName, extension, contentType);
        byte[] bufferArray = new byte[1024];
        long size = 0;
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
            int nread = -1;
            while ((nread = fileStream.read(bufferArray)) != -1) {
                buffer.write(bufferArray, 0, nread);
                size += nread;
            }
            byte[] data = buffer.toByteArray();
            image.setData(data);
        }
        image.setSize(size);
        return image;
    }

}
