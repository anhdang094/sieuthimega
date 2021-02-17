package vn.smart.admin.application.rest;

import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.smart.admin.application.dto.GenericDto;
import vn.smart.admin.application.service.ImageService;
import vn.smart.admin.domain.model.Image;
import vn.smart.admin.infrastructure.utils.StringUtils;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ImageController extends AbstractController {

    @Autowired
    private ImageService imageService;

    /**
     * api will return byte render in output stream
     */
    @RequestMapping(value = "/{imageId}", method = RequestMethod.GET)
    public void loadImageById(HttpServletResponse response, @PathVariable int imageId) {
        try {
            Image image = imageService.getImageById(imageId);
            if (image != null && image.getData().length > 0) {
                IOUtils.write(image.getData(), response.getOutputStream());
            } else {
                response.setStatus(HttpStatus.NO_CONTENT.value());
                return;
            }
            response.flushBuffer();
        } catch (Exception ex) {
            _logger.error("Error on image api", ex);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @RequestMapping(value = "/images", method = RequestMethod.POST)
    @ApiOperation(value = "upload-image",
            produces = "application/json", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadImageForTicket(@RequestPart MultipartFile uploadFile) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(new GenericDto(imageService.uploadImage(uploadFile))), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

    /**
     * api will delete image of userID if it not grant any ticket
     */
    @RequestMapping(value = "/images/{imageID}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteImageById(@PathVariable String imageID) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(imageService.deleteImage(imageID)), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

}
