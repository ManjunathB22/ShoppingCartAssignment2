package com.ultralesson.objectorientation;

import com.ultralesson.objectorientation.products.Apple;
import com.ultralesson.objectorientation.products.Milk;
import com.ultralesson.objectorientation.products.Newspaper;
import com.ultralesson.objectorientation.services.CartServices;
import com.ultralesson.objectorientation.services.CustomerCart;
import com.ultralesson.objectorientation.services.EWallet;
import com.ultralesson.objectorientation.services.Offers;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartTest {


    @Test
    public void verifyCartPriceWithDiscount() throws Exception {
        EWallet wallet = new EWallet(1000);
        CustomerCart customerCart1 = new CustomerCart(wallet);
        Apple apple1 = new Apple(3, 30.00, "Red");
        Newspaper newspaper1 = new Newspaper(2, 5.00, "TOI");
        Milk milk1 = new Milk(7, 10, "Dairy");
        customerCart1.addToCart(apple1);
        customerCart1.addToCart(newspaper1);
        customerCart1.addToCart(milk1);
        System.out.println("Apple Total is :"+ customerCart1.getIndividualProductPrice(apple1));
        System.out.println("NewsPaper Total is :"+ customerCart1.getIndividualProductPrice(newspaper1));
        System.out.println("Milk Total is :"+ customerCart1.getIndividualProductPrice(milk1));
        customerCart1.getNumberOfProducts();
        customerCart1.getBuy2Get1MilkOffer(milk1.quantity());
        double totalCartPriceafterDiscount = customerCart1.getTotalCartAmount();
        Assert.assertEquals(totalCartPriceafterDiscount,161.5);
    }

    @Test
    public void verifyCartPriceWithoutDiscount() throws Exception {
        EWallet wallet = new EWallet(1000);
        CustomerCart customerCart1 = new CustomerCart(wallet);
        Apple apple1 = new Apple(2, 30.00, "Red");
        Newspaper newspaper1 = new Newspaper(2, 5.00, "TOI");
        Milk milk1 = new Milk(1, 10, "Dairy");
        customerCart1.addToCart(apple1);
        customerCart1.addToCart(newspaper1);
        customerCart1.addToCart(milk1);
        System.out.println("Apple Total is :"+ customerCart1.getIndividualProductPrice(apple1));
        System.out.println("NewsPaper Total is :"+ customerCart1.getIndividualProductPrice(newspaper1));
        System.out.println("Milk Total is :"+ customerCart1.getIndividualProductPrice(milk1));
        customerCart1.getNumberOfProducts();
        customerCart1.getBuy2Get1MilkOffer(milk1.quantity());
        double totalCartPriceafterDiscount = customerCart1.getTotalCartAmount();
        Assert.assertEquals(totalCartPriceafterDiscount,80.0);
    }

    @Test
    public void verifyAddingMoreProductsThanBalanceAmount() throws Exception {
        EWallet wallet = new EWallet(1000);
        CustomerCart customerCart1 = new CustomerCart(wallet);
        Apple apple1 = new Apple(2, 300.00, "Red");
        Newspaper newspaper1 = new Newspaper(2, 50.00, "TOI");
        Milk milk1 = new Milk(7, 100, "Dairy");
        customerCart1.addToCart(apple1);
        customerCart1.addToCart(newspaper1);
        customerCart1.addToCart(milk1);
        System.out.println("Apple Total is :"+ customerCart1.getIndividualProductPrice(apple1));
        System.out.println("NewsPaper Total is :"+ customerCart1.getIndividualProductPrice(newspaper1));
        System.out.println("Milk Total is :"+ customerCart1.getIndividualProductPrice(milk1));
        customerCart1.getNumberOfProducts();
        customerCart1.getBuy2Get1MilkOffer(milk1.quantity());
        double totalCartPriceafterDiscount = customerCart1.getTotalCartAmount();
        Assert.assertEquals(totalCartPriceafterDiscount,1615.0);
    }

    @Test
    public void VerifyAddingProductsMoreThanThresold() throws Exception {
        EWallet wallet = new EWallet(1000);
        CustomerCart customerCart3 = new CustomerCart(wallet);
        Apple apple1 = new Apple(10, 30.00, "Red");
        Newspaper newspaper1 = new Newspaper(2, 5.00, "TOI");
        Milk milk1 = new Milk(1, 10, "Dairy");
        customerCart3.addToCart(apple1);
        customerCart3.addToCart(newspaper1);
        customerCart3.addToCart(milk1);
        customerCart3.getNumberOfProducts();
    }

    @Test
    public void verifyAddingWalletMoney(){
        EWallet wallet = new EWallet(0);
        CustomerCart customerCart4 = new CustomerCart(wallet);
        double addMonetToWallet = customerCart4.addMoneyToWallet(100);
        Assert.assertEquals(addMonetToWallet,100);
    }

    @AfterClass
    public void welcomeMessage(){
        System.out.println("Thank you for Shopping");
    }
}
