package com.betaexpress.domain.model;

import com.betaexpress.domain.exception.InvalidValidityException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;

public class Grocery extends Product {

    private String distributor;
    private float weight;
    private LocalDateTime validity;

    public Grocery(String name, float price, String description, String distributor, Float weight, LocalDateTime validity) {
        super(name, price, description);
        this.distributor = distributor;
        this.weight = weight;
        this.validity = validity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(this.distributor);
        sb.append(";");
        sb.append(this.weight);
        sb.append(";");
        sb.append(this.validity);

        return sb.toString();
    }

    @Override
    protected float priceCalc() {
        if (ChronoUnit.MONTHS.between(LocalDate.now(), validity) <= 1)
            return getPrice() / 2;
        return getPrice();
    }

    public Boolean checkExpirationDate() throws InvalidValidityException {
        if (LocalDateTime.now().isAfter(ChronoLocalDateTime.from(validity)))
            throw new InvalidValidityException("grocery expired");
        return false;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public LocalDateTime getValidity() {
        return validity;
    }

    public void setValidity(LocalDateTime validity) {
        this.validity = validity;
    }
}
