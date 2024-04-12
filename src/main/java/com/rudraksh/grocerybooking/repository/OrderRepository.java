package com.rudraksh.grocerybooking.repository;

import com.rudraksh.grocerybooking.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<GroceryItem, Long> {
}
