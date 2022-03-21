package com.ultralesson.objectorientation.services;

import com.ultralesson.objectorientation.products.Products;

import java.util.List;

public class CustomerCart {
    private EWallet wallet;
    private CartServices cart;
    private Offers offers;

    public CustomerCart(EWallet wallet) {
        this.wallet = wallet;
        cart= new CartServices();
        offers = new Offers();
    }

    public void addToCart(Products products){
        cart.addProduct(products);
    }

    public void removeFromCart(Products product) { cart.removeProduct(product);}

    public List<Products> getProductsList(){ return cart.getList();}

    public double getIndividualProductPrice(Products products){return cart.subTotal(products);}

    public void getNumberOfProducts() throws Exception {cart.numberOfProducts();}

    public double getTotalCartAmount() throws Exception {
        double totalPrice = cart.totalPrice();
        System.out.println("Total Cart Price "+totalPrice);
        double totalCartPriceAfterDiscount = offers.above100OfferOf5Percent(totalPrice);
        System.out.println("Total Cart Price after Discount "+totalCartPriceAfterDiscount);
        wallet.deductBalance(totalCartPriceAfterDiscount);
        System.out.println("Your Wallet balance is "+wallet.getWalletBalance());
        return totalCartPriceAfterDiscount;
    }

    public void getBuy2Get1MilkOffer(int milkCount){offers.buy2MilkGet1FreeOffer(milkCount);}


    public double getWalletAmount(){
        return wallet.getWalletBalance();
    }

    public double addMoneyToWallet(double amount){
        double totalAmountInWallet=wallet.addBalance(amount);
        return totalAmountInWallet;
    }

}
