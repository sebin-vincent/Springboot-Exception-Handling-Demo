package com.demo.exceptionhandler.demo.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@NoArgsConstructor
public class OrderException extends RuntimeException{

    public OrderException(Map<String,Object> error){
        this.errorReason=error;
    }

    String msg="";
    HttpStatus httpStatus=HttpStatus.OK;

    Map<String,Object> errorReason;


}
