package com.demo.exceptionhandler.demo.controller;

import com.demo.exceptionhandler.demo.dto.ResponseInfo;
import com.demo.exceptionhandler.demo.dto.request.OrderRequest;
import com.demo.exceptionhandler.demo.service.OrderService;
import com.demo.exceptionhandler.demo.service.Previlege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Previlege("createOrder")
    @PostMapping("/order/api/v1/place-order")
    public ResponseEntity<ResponseInfo> createOrder(@RequestBody OrderRequest orderRequest){

       int orderId= orderService.placeOrder(orderRequest);

        ResponseInfo responseInfo=new ResponseInfo();
        responseInfo.setPayload(orderId);
        responseInfo.setStatus("Success");
        responseInfo.setResponseMsg("Order created successfully");

        return new ResponseEntity<>(responseInfo, HttpStatus.OK);
    }

}
