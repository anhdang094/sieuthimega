package vn.smart.web.application.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.smart.web.application.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController extends AbstractController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/infor", method = RequestMethod.GET)
    @ApiOperation(value = "get all product infor")
    public ResponseEntity<?> getProductInfor(@RequestParam String productId) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(productService.findProductInfo(Integer.valueOf(productId))), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/merchants", method = RequestMethod.GET)
    @ApiOperation(value = "get all product merchants")
    public ResponseEntity<?> getProductOfMerchantsByMerchantId(@RequestParam String merchantId, @RequestParam String page, @RequestParam String pageSize) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(productService.getProductOfMerchantsByMerchantId(
                    Long.valueOf(merchantId), Integer.valueOf(page), Integer.valueOf(pageSize)
            )), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/suggesstion", method = RequestMethod.GET)
    @ApiOperation(value = "get all product suggesstion")
    public ResponseEntity<?> getProductSuggesstion(@RequestParam String productIds) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(productService.getProductSuggesstion(productIds)), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/filters", method = RequestMethod.GET)
    @ApiOperation(value = "get all product by filter")
    public ResponseEntity<?> getProductByFilter(@RequestParam String name) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(productService.getProductForSearchByFilter(name)), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    @ApiOperation(value = "get product by id")
    public ResponseEntity<?> getProductById(@PathVariable String productId) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(productService.getProductById(Integer.valueOf(productId))), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }
}
