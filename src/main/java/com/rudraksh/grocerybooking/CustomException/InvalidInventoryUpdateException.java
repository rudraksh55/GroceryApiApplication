package com.rudraksh.grocerybooking.CustomException;

public class InvalidInventoryUpdateException extends  RuntimeException {

    public InvalidInventoryUpdateException(String message) {
        super("Invalid Operation");

    }
}
