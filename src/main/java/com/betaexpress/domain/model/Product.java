package com.betaexpress.domain.model;

public abstract class Product {

    protected String name;
    protected float price;
    protected String description;
    protected int qty;

    public Product() {
        this.qty = 1;
    }

    public Product(String name, float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.qty = 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.qty);
        sb.append(";");
        sb.append(this.name);
        sb.append(";");
        sb.append(this.priceCalc());
        sb.append(";");
        sb.append(this.description);

        return sb.toString();
    }

    protected abstract float priceCalc();

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void incQty() {
        qty++;
    }
    
    public static Product dummyProduct() {
        return new Product() {
            @Override
            protected float priceCalc() {
                return 0;
            }
        };
    }
}
