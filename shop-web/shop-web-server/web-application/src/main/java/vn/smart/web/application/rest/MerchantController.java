package vn.smart.web.application.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.smart.web.application.service.MerchantService;

@RestController
@CrossOrigin
@RequestMapping("/api/merchants")
public class MerchantController extends AbstractController {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "/{merchantId}", method = RequestMethod.GET)
    @ApiOperation(value = "get merchant infor")
    public ResponseEntity<?> getMerchantInfor(@PathVariable String merchantId) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(merchantService.findMerchantInfor(Integer.valueOf(merchantId))), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

}
