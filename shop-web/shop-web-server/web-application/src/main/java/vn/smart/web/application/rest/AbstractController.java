package vn.smart.web.application.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.smart.web.infrastructure.enumeration.ErrorMessage;
import vn.smart.web.infrastructure.response.DefaultResponse;

public class AbstractController {

    protected static Logger _logger = LoggerFactory.getLogger(AbstractController.class);

    protected DefaultResponse buildSuccessResponse(Object data) {
        DefaultResponse response = new DefaultResponse();
        response.setReturnCode(ErrorMessage.SUCCESS.getCode());
        response.setReturnMessage(ErrorMessage.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }

    protected DefaultResponse buildInvalidResponse() {
        DefaultResponse response = new DefaultResponse();
        response.setReturnCode(ErrorMessage.INVALID_PARAM.getCode());
        response.setReturnMessage(ErrorMessage.INVALID_PARAM.getMessage());
        return response;
    }

    protected DefaultResponse buildAccessFailResponse() {
        DefaultResponse response = new DefaultResponse();
        response.setReturnCode(ErrorMessage.ACCESS_FAIL.getCode());
        response.setReturnMessage(ErrorMessage.ACCESS_FAIL.getMessage());
        return response;
    }

    protected DefaultResponse buildFailResponse() {
        DefaultResponse response = new DefaultResponse();
        response.setReturnCode(ErrorMessage.FAIL.getCode());
        response.setReturnMessage(ErrorMessage.FAIL.getMessage());
        return response;
    }

    protected DefaultResponse buildNoContentResponse() {
        DefaultResponse response = new DefaultResponse();
        response.setReturnCode(ErrorMessage.SUCCESS.getCode());
        response.setReturnMessage(ErrorMessage.SUCCESS.getMessage());
        response.setData(null);
        return response;
    }

}
