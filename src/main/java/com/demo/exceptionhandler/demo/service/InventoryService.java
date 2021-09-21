package com.demo.exceptionhandler.demo.service;

import com.demo.exceptionhandler.demo.dto.ResponseInfo;

public interface InventoryService {

    ResponseInfo updateInventory(int productId, int quantity);
}
