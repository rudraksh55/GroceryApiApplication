package com.rudraksh.grocerybooking.service;

import com.rudraksh.grocerybooking.model.GroceryItem;
import com.rudraksh.grocerybooking.model.OrderEntity;


import java.util.List;


public interface UserService {
    List<GroceryItem> getAllGroceryItems();

    OrderEntity placeOrder(OrderEntity orderEntity);
}
