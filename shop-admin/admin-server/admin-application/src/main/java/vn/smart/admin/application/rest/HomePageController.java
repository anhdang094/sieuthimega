package vn.smart.admin.application.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vn.smart.admin.application.service.HomePageService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HomePageController extends AbstractController {

    @Autowired
    private HomePageService homePageService;

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


}
