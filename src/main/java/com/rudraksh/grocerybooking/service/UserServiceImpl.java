package com.rudraksh.grocerybooking.service;

import com.rudraksh.grocerybooking.CustomException.InvalidInventoryUpdateException;
import com.rudraksh.grocerybooking.CustomException.ItemNotFoundException;
import com.rudraksh.grocerybooking.model.GroceryItem;
import com.rudraksh.grocerybooking.model.OrderEntity;
import com.rudraksh.grocerybooking.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl  implements  UserService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<GroceryItem> getAllGroceryItems(){
    return orderRepository.findAll();

    }

    @Override
    public OrderEntity placeOrder(OrderEntity orderEntity) {

        for (GroceryItem item : orderEntity.getItems()) {
            GroceryItem existingItem = orderRepository.findById(item.getId())
                    .orElseThrow(() -> new ItemNotFoundException("Item not found"));
            int newQuantity = existingItem.getQuantity() - item.getQuantity();
            if (newQuantity < 0) {
                throw new InvalidInventoryUpdateException("Insufficient quantity for item: " + existingItem.getName());
            }
            existingItem.setQuantity(newQuantity);
            orderRepository.save(existingItem);
        }

        return orderEntity;
    }

}
