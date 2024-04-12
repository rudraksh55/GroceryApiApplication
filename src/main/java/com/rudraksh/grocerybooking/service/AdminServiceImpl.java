package com.rudraksh.grocerybooking.service;

import com.rudraksh.grocerybooking.CustomException.InvalidInventoryUpdateException;
import com.rudraksh.grocerybooking.CustomException.ItemNotFoundException;
import com.rudraksh.grocerybooking.model.GroceryItem;
import com.rudraksh.grocerybooking.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl   implements  AdminService{

//        private final ArrayList<GroceryItem> groceryItems;
//
//      public AdminServiceImpl() {
//
//            groceryItems = new ArrayList<>();
//
//            groceryItems.add(new GroceryItem(1L,"Apple",2.50,90));
//          groceryItems.add(new GroceryItem(2L,"Banana",2.50,90));
//          groceryItems.add(new GroceryItem(3L,"Orange",2.50,90));
//
//
//        }

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Override
    public GroceryItem addGroceryItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    @Override
    public void removeGroceryItem(Long id) {
        groceryItemRepository.deleteById(id);
    }


    @Override
    public GroceryItem updateGroceryItem(GroceryItem item, Long id) {
        GroceryItem updateGrocery = groceryItemRepository.findById(id).orElse(null);
        if (updateGrocery != null) {
            if (Objects.nonNull(item.getName()) && !"".equalsIgnoreCase(item.getName())) {
                updateGrocery.setName(item.getName());
            }

            if (item.getPrice() != 0.0) {
                updateGrocery.setPrice(item.getPrice());
            }
        }
        return groceryItemRepository.save(updateGrocery);
    }

    @Override
    public GroceryItem manageInventory(Long id, int quantity) {
        GroceryItem item = groceryItemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found"));
        int newQuantity = item.getQuantity() + quantity;
        if (newQuantity < 0) {
            throw new InvalidInventoryUpdateException("Quantity cannot be negative");
        }
        item.setQuantity(newQuantity);
        groceryItemRepository.save(item);
        return item;
    }
}