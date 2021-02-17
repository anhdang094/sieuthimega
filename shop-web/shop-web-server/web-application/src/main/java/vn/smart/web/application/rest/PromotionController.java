package vn.smart.web.application.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vn.smart.web.application.service.PromotionService;

@RestController
@CrossOrigin
@RequestMapping("/api/promotions")
public class PromotionController extends AbstractController {

    @Autowired
    private PromotionService promotionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "get all promotions")
    public ResponseEntity<?> getAllPromotion() {
        try {
            return new ResponseEntity<>(buildSuccessResponse(promotionService.getAllPromotionActive()), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

}
