package com.ultralesson.objectorientation.services;

import com.ultralesson.objectorientation.products.Products;

import java.util.ArrayList;
import java.util.List;

public class CartServices {
    private List<Products> list;
    private double totalAmount=0;
    private int productThresold = 12;

    public List<Products> getList() {
        return list;
    }

    public CartServices() {
        list= new ArrayList<>();
    }

    public void addProduct(Products product){
        list.add(product);
    }

    public void removeProduct(Products product){list.remove(product);}

    public void numberOfProducts() throws Exception {
        int totalProductCount=0;
        for (Products products : getList()){
            totalProductCount=totalProductCount+products.quantity();
        }
        if(totalProductCount<=productThresold){
            System.out.println("Number of products in cart is "+totalProductCount);
        }
        else {
            throw new Exception("Product threshold Overload, Add only 12 products to cart");
        }
    }

    public double subTotal(Products product){
        totalAmount= product.quantity()* product.prodPrice();
        return totalAmount;
    }

    public double totalPrice(){
        Offers offers =  new Offers();
        double total=0;
        for (Products products : getList()) {
            total= total+subTotal(products);
        }
        return total;
    }
}
