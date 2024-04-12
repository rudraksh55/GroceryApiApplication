package com.rudraksh.grocerybooking.controller;

import com.rudraksh.grocerybooking.model.GroceryItem;
import com.rudraksh.grocerybooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService  adminService;

    @PostMapping("/grocery")
    public GroceryItem addGroceryItem(@RequestBody GroceryItem item) {
        return adminService.addGroceryItem(item);
        
    }

    @GetMapping("/GetItems")
    public List<GroceryItem> getAllGroceryItems() {
        return adminService.getAllGroceryItems();
    }

    @DeleteMapping("/delGrocery/{id}")
    public String removeGroceryItem(@PathVariable Long id) {
        adminService.removeGroceryItem(id);
        return "Deleted Successfully";
    }

    @PutMapping("/updateGroc/{id}")
    public GroceryItem updateGroceryItem(@RequestBody GroceryItem item, @PathVariable("id") Long id) {
        return adminService.updateGroceryItem(item,id);
    }

    @PutMapping("/inventory/{id}/{quantity}")
    public ResponseEntity<GroceryItem> manageInventory(@PathVariable("id") Long id , @PathVariable("quantity") int  quantity) {

        GroceryItem updatedItem = adminService.manageInventory(id, quantity);
        return ResponseEntity.ok(updatedItem);
    }
}