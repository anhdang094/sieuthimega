package vn.smart.web.application.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.smart.web.application.service.HomePageService;
import vn.smart.web.application.service.ImageService;
import vn.smart.web.application.service.SearchService;

@RestController
@CrossOrigin
@RequestMapping("/api/search")
public class SearchController extends AbstractController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    @ApiOperation(value = "get all menu")
    public ResponseEntity<?> getMenu() {
        try {
            return new ResponseEntity<>(buildSuccessResponse(searchService.getMenuSearch()), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

}
