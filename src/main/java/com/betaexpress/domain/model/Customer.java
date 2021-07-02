package com.betaexpress.domain.model;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    private boolean registered;
    private final Cart cart;

    public Customer() {
        cart = new Cart();
    }

    public Customer(String firstName, String lastName, String email, Boolean registered) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registered = registered;
        this.cart = new Cart();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.firstName);
        sb.append(";");
        sb.append(this.lastName);
        sb.append(";");
        sb.append(this.email);
        sb.append(";");
        sb.append(this.registered ? "Y" : "N");
        sb.append(";");
        sb.append(cart);

        return sb.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public Cart getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }
}
