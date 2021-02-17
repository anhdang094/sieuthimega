package vn.smart.web.application.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vn.smart.web.application.service.ConfigService;

@RestController
@CrossOrigin
@RequestMapping("/api/configs")
public class ConfigController extends AbstractController {

    @Autowired
    private ConfigService configService;

    @RequestMapping(value = "/fee", method = RequestMethod.GET)
    @ApiOperation(value = "get default fee")
    public ResponseEntity<?> getFeeDelivery() {
        try {
            return new ResponseEntity<>(buildSuccessResponse(configService.getDefaultFee()), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

}
