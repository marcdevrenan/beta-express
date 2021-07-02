package com.betaexpress.domain.test;

import com.betaexpress.domain.exception.InvalidValidityException;
import com.betaexpress.domain.model.Grocery;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class GroceryTest {

    public static void main(String[] args) {

        Grocery g1 = new Grocery("Ruffles", 9.98f, "lorem ipsum", "Elma Chips", 90f, LocalDateTime.now().plus(2, ChronoUnit.DAYS));

        try {
            g1.checkExpirationDate();
            System.out.println(g1);
        } catch (InvalidValidityException e) {
            e.printStackTrace();
        }
    }
}
