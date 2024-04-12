package com.rudraksh.grocerybooking.controller;

import com.rudraksh.grocerybooking.model.GroceryItem;
import com.rudraksh.grocerybooking.model.OrderEntity;
import com.rudraksh.grocerybooking.repository.GroceryItemRepository;
import com.rudraksh.grocerybooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/Order-list")
    public List<GroceryItem> getAllGroceryItems() {
        return userService.getAllGroceryItems();
    }


    @PostMapping("/place-order")
    public ResponseEntity<OrderEntity> placeOrder(@RequestBody OrderEntity order) {
        OrderEntity placeOrder=userService.placeOrder(order);
        return ResponseEntity.ok(placeOrder);
    }
}
