package vn.smart.admin.application.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.smart.admin.domain.model.Image;

@Service
public interface ImageService {

    Image getImageById(int imageId);

    /**
     * upload image with support multipart
     * @param uploadFile
     * @return
     */
    Integer uploadImage(MultipartFile uploadFile);

    /**
     * delete iamge of userID, current method will delete image use miss upload
     * @param imageID
     * @return
     */
    boolean deleteImage(String imageID);

    /**
     * this method is get all url of image of ticket
     * @param ticketID
     * @param userID
     * @param currentPath
     * @return
     */

}
