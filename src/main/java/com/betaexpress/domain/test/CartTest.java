package com.betaexpress.domain.test;

import com.betaexpress.domain.model.Cart;
import com.betaexpress.domain.model.Clothing;
import com.betaexpress.domain.model.Electronic;
import com.betaexpress.domain.model.Grocery;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CartTest {

    public static void main(String[] args) {

        Clothing c1 = new Clothing("jacket", 50f, "lorem ipsum", true, "GG", "blue");
        Electronic e1 = new Electronic("Poco X3", 1500f, "lorem ipsum","Xiaomi", 110, false);
        Grocery g1 = new Grocery("Ruffles", 9.98f, "lorem ipsum", "Elma Chips", 90f, LocalDateTime.now().minus(2, ChronoUnit.DAYS));

        Cart cart = new Cart();
        cart.add(c1);
        cart.add(c1);
        cart.add(e1);
        cart.add(g1);
        cart.add(g1);
        cart.add(g1);
        System.out.println(cart);
    }
}
