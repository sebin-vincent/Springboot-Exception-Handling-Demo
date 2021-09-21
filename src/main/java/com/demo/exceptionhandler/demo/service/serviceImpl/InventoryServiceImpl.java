package com.demo.exceptionhandler.demo.service.serviceImpl;

import com.demo.exceptionhandler.demo.dto.ResponseInfo;
import com.demo.exceptionhandler.demo.service.InventoryService;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {



    @Override
    public ResponseInfo updateInventory(int productId, int quantity) {

        ResponseInfo responseInfo =new ResponseInfo();
        responseInfo.setStatus("failed");
        responseInfo.setResponseMsg("Inventory out of stock!!");
        return responseInfo;
    }
}
