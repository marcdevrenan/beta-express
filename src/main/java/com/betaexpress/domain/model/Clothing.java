package com.betaexpress.domain.model;

import com.betaexpress.domain.exception.InvalidSizeException;

import java.util.Arrays;
import java.util.List;

public class Clothing extends Product {

    private boolean brand;
    private String size;
    private String color;
    public static final List<String> possibleSizes = Arrays.asList("pp", "PP", "p", "P", "m", "M", "g", "G", "gg", "GG", "xxl", "XXL");

    public Clothing(String name, float price, String description, boolean brand, String size, String color) {
        super(name, price, description);
        this.brand = brand;
        this.size = size;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(this.brand ? "Y" : "N");
        sb.append(";");
        sb.append(this.size);
        sb.append(";");
        sb.append(this.color);

        return sb.toString();
    }

    @Override
    public float priceCalc() {

        float price = getPrice();
        if (this.brand) {
            price += getPrice() * 0.1f;
        }

        if (this.size.equalsIgnoreCase("xxl")) {
            price += getPrice() * 0.1f;
        }

        return price;
    }

    public boolean checkSize() throws InvalidSizeException {
        if (!possibleSizes.contains(getSize()))
            throw new InvalidSizeException("invalid size");
        return false;
    }

    public boolean isBrand() {
        return brand;
    }

    public void setBrand(boolean brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
