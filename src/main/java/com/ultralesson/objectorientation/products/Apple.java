package com.ultralesson.objectorientation.products;

public class Apple implements Products {
    private int quantity;
    private double productAmount;
    private String productName;

    public Apple(int quantity, double productAmount, String productName) {
        this.quantity = quantity;
        this.productAmount = productAmount;
        this.productName = productName;
    }
    

    @Override
    public int quantity() {
        return quantity;
    }

    @Override
    public String prodName() {
        return productName;
    }

    @Override
    public double prodPrice() {
        return productAmount;
    }
}


