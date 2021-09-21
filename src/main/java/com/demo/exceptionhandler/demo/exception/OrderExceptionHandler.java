package com.demo.exceptionhandler.demo.exception;

import com.demo.exceptionhandler.demo.dto.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class OrderExceptionHandler extends ResponseEntityExceptionHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderExceptionHandler.class);

    @ExceptionHandler(OrderException.class)
    public final ResponseEntity<ResponseInfo> handleMarketGeneralException(
            final OrderException ex
    ) {
        final Map<String,Object> error = ex.getErrorReason();

        ResponseInfo errorResponseInfo=new ResponseInfo();
        errorResponseInfo.setStatus(error.get("status").toString());
        errorResponseInfo.setResponseMsg((error.get("message").toString()));

        final HttpStatus httpStatus = ex.getHttpStatus();

        return new ResponseEntity<>(errorResponseInfo, httpStatus);
    }

}
