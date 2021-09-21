package com.demo.exceptionhandler.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseInfo {

    public ResponseInfo(String status) {
        this.status = status;
    }

    private String status;

    private String responseMsg;

    private Object payload;
}
