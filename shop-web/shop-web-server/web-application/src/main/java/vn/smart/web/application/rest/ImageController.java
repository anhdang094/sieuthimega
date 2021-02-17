package vn.smart.web.application.rest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.smart.web.application.service.ImageService;
import vn.smart.web.domain.model.Image;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/images")
public class ImageController extends AbstractController {

    @Autowired
    private ImageService imageService;

    /**
     * api will return byte render in output stream
     */
    @RequestMapping(value = "/{imageId}-{isCache}.png", method = RequestMethod.GET)
    public void loadImageById(HttpServletResponse response, @PathVariable int imageId, @PathVariable boolean isCache) {
        try {
            Image image = imageService.getImageById(imageId, isCache);
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

    @RequestMapping(value = "ads", method = RequestMethod.GET)
    public ResponseEntity<?> loadImageAdsHeader(@RequestParam Integer type) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(imageService.loadImageAdsHeader(type)), HttpStatus.OK);
        } catch (Exception ex) {
            _logger.error("Error on ads api", ex);
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

}
