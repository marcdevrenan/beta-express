package com.betaexpress.domain.test;

import com.betaexpress.domain.exception.InvalidSizeException;
import com.betaexpress.domain.model.Clothing;

public class ClothingTest {

    public static void main(String[] args) {

        Clothing c1 = new Clothing("Jacket", 80f, "lorem ipsum", true, "GG", "Blue");

        try {
            c1.checkSize();
            System.out.println(c1);
        } catch (InvalidSizeException e) {
            e.printStackTrace();
        }
    }
}
