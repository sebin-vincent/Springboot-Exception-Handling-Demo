package com.demo.exceptionhandler.demo.service.serviceImpl;

import com.demo.exceptionhandler.demo.dto.ResponseInfo;
import com.demo.exceptionhandler.demo.dto.request.OrderRequest;
import com.demo.exceptionhandler.demo.exception.OrderException;
import com.demo.exceptionhandler.demo.service.InventoryService;
import com.demo.exceptionhandler.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private InventoryService inventoryService;


    //todo @Transactional
    @Override
    public int placeOrder(OrderRequest orderRequest) {


        int productId=orderRequest.getProductId();
        int quantity=orderRequest.getProductQuantity();


        //check if product exists


        int orderId=123; //create order in orderDB.order table and return orderId created;


        //Rest call to update inventory stock details
        ResponseInfo inventoryResponse=inventoryService.updateInventory(productId,quantity);

        if(inventoryResponse.getStatus().equalsIgnoreCase("failed")){
            Map<String,Object> error=new HashMap<>();
            error.put("status","failed");
            error.put("message",inventoryResponse.getResponseMsg());
            throw new OrderException(error);
        }

        return orderId;
    }
}
