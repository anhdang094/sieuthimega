package vn.smart.admin.application.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.smart.admin.application.dto.ProductDto;
import vn.smart.admin.application.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController extends AbstractController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    @ApiOperation(value = "get all menu")
    public ResponseEntity<?> getMenu(@RequestBody ProductDto productDto) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(productService.registerProduct(productDto)), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

}
