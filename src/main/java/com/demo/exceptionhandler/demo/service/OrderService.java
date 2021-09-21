package com.demo.exceptionhandler.demo.service;

import com.demo.exceptionhandler.demo.dto.request.OrderRequest;

public interface OrderService {

    int placeOrder(OrderRequest orderRequest);
}
