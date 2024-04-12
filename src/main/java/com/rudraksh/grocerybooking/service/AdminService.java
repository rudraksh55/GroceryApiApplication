package com.rudraksh.grocerybooking.service;

import com.rudraksh.grocerybooking.model.GroceryItem;


import java.util.List;


public interface AdminService  {

    GroceryItem addGroceryItem(GroceryItem item);

    List<GroceryItem> getAllGroceryItems();

    void removeGroceryItem(Long id);



    GroceryItem updateGroceryItem(GroceryItem item, Long id);

    GroceryItem manageInventory(Long id, int quantity);
}
