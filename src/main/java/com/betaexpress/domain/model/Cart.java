package com.betaexpress.domain.model;

import java.util.HashMap;

public class Cart {

    private HashMap<String, Product> cartItems;

    public Cart() {
        cartItems = new HashMap<>();
    }

    public void add(Product product) {
        if (cartItems.containsKey(product.getName())) {
            cartItems.get(product.getName()).incQty();
        } else {
            cartItems.put(product.getName(), product);
        }
    }

    @Override
    public String toString() {
        return "Cart = " + cartItems;
    }
}
