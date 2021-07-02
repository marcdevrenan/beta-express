package com.betaexpress.domain.model;

import com.betaexpress.domain.exception.InvalidVoltageException;

public class Electronic extends Product {

    private String manufacturer;
    private int voltage;
    private boolean national;

    public Electronic(String name, float price, String description, String manufacturer, Integer voltage, Boolean national) {
        super(name, price, description);
        this.manufacturer = manufacturer;
        this.voltage = voltage;
        this.national = national;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(this.manufacturer);
        sb.append(";");
        sb.append(this.voltage);
        sb.append(";");
        sb.append(this.national ? "Y" : "N");

        return sb.toString();
    }

    @Override
    public float priceCalc() {
        float price = getPrice();
        if (!this.national) {
            price += getPrice() * 0.4f;
        }

        return price;
    }

    public boolean checkVoltage() throws InvalidVoltageException {
        if (voltage != 110 && voltage != 220)
            throw new InvalidVoltageException("invalid voltage");
        return false;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public boolean isNational() {
        return national;
    }

    public void setNational(boolean national) {
        this.national = national;
    }
}
