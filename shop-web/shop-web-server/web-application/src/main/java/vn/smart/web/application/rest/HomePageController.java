package vn.smart.web.application.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.smart.web.application.service.HomePageService;
import vn.smart.web.application.service.ImageService;
import vn.smart.web.infrastructure.enumeration.AdsPosition;
import vn.smart.web.infrastructure.enumeration.HomeProductType;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HomePageController extends AbstractController {

    @Autowired
    private HomePageService homePageService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    @ApiOperation(value = "get all menu")
    public ResponseEntity<?> getMenu() {
        try {
            return new ResponseEntity<>(buildSuccessResponse(homePageService.getMenu()), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/slide", method = RequestMethod.GET)
    @ApiOperation(value = "get all slide")
    public ResponseEntity<?> getSilde() {
        try {
            return new ResponseEntity<>(buildSuccessResponse(homePageService.getSlide()), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/menu-by-date", method = RequestMethod.GET)
    @ApiOperation(value = "get all menu by date")
    public ResponseEntity<?> getMenuByDay() {
        try {
            return new ResponseEntity<>(buildSuccessResponse(homePageService.getMenuByDay()), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/best-buy", method = RequestMethod.GET)
    @ApiOperation(value = "get all best buy")
    public ResponseEntity<?> getAllBestBuy() {
        try {
            return new ResponseEntity<>(buildSuccessResponse(homePageService.getAllBestBuy()), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "collections", method = RequestMethod.GET)
    public ResponseEntity<?> loadCollectionHome() {
        try {
            return new ResponseEntity<>(buildSuccessResponse(homePageService.getAllCollection()), HttpStatus.OK);
        } catch (Exception ex) {
            _logger.error("Error on collections api", ex);
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "quick-deal", method = RequestMethod.GET)
    public ResponseEntity<?> loadQuickDeal() {
        try {
            return new ResponseEntity<>(buildSuccessResponse(homePageService.loadQuickDeal()), HttpStatus.OK);
        } catch (Exception ex) {
            _logger.error("Error on quick-deal api", ex);
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "products/home", method = RequestMethod.GET)
    public ResponseEntity<?> loadBaseProductHome(@RequestParam Integer type) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(homePageService.loadHomeBasicProduct(type)), HttpStatus.OK);
        } catch (Exception ex) {
            _logger.error("Error on products home api", ex);
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }
}
