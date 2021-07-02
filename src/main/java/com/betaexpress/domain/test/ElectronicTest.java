package com.betaexpress.domain.test;

import com.betaexpress.domain.exception.InvalidVoltageException;
import com.betaexpress.domain.model.Electronic;

public class ElectronicTest {

    public static void main(String[] args) {

        Electronic e1 = new Electronic("Poco X3", 1500f, "lorem ipsum","Xiaomi", 110, false);

        try {
            e1.checkVoltage();
            System.out.println(e1);
        } catch (InvalidVoltageException e) {
            e.printStackTrace();
        }
    }
}
