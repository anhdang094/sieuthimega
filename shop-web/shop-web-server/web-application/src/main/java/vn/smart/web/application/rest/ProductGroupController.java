package vn.smart.web.application.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.smart.web.application.service.ProductGroupService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductGroupController extends AbstractController {

    @Autowired
    private ProductGroupService productGroupService;

    @RequestMapping(value = "/menu-group", method = RequestMethod.GET)
    @ApiOperation(value = "get all menu group")
    public ResponseEntity<?> getMenuinProductGroup(@RequestParam String filter) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(productGroupService.findAllByType(filter)), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    @ApiOperation(value = "get all products by page")
    public ResponseEntity<?> getAllProductInGroup(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam String filter) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(
                    productGroupService.getAllProductInGroup(filter, page, pageSize)), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

}
