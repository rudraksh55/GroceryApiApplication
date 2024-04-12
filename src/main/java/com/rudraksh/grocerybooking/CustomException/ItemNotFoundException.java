package com.rudraksh.grocerybooking.CustomException;

public class ItemNotFoundException  extends  RuntimeException {

    public ItemNotFoundException(String message) {
        super("Item not found");
    }
}
