package vn.smart.web.application.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.smart.web.application.dto.FeedbackDto;
import vn.smart.web.application.service.EvalutionService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EvalutionController extends AbstractController {

    @Autowired
    private EvalutionService evalutionService;

    @RequestMapping(value = "products/comments", method = RequestMethod.GET)
    @ApiOperation(value = "get all product comments")
    public ResponseEntity<?> getAllCommentOfProduct(@RequestParam String productId, @RequestParam String page, @RequestParam String pageSize) {
        try {
            return new ResponseEntity<>(buildSuccessResponse(evalutionService.getAllCommentByProductId(
                    Integer.valueOf(productId), Integer.valueOf(page), Integer.valueOf(pageSize))), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "feedbacks", method = RequestMethod.POST)
    @ApiOperation(value = "post feedback")
    public ResponseEntity<?> postFeedback(@RequestBody FeedbackDto feedbackDto) {
        try {
            evalutionService.postFeedBack(feedbackDto.getEmail(), feedbackDto.getContent());
            return new ResponseEntity<>(buildNoContentResponse(), HttpStatus.OK);
        } catch (Exception e) {
            _logger.error("Exception " + e.getMessage());
            return new ResponseEntity<>(buildFailResponse(), HttpStatus.OK);
        }
    }
}
