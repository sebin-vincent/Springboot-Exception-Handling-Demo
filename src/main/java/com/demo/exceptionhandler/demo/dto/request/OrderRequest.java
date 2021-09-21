package com.demo.exceptionhandler.demo.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequest {

    int productId;

    @Min(1)
    int productQuantity;

    @NotEmpty
    String address;
}
