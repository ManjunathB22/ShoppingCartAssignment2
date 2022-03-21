package com.ultralesson.objectorientation.services;

public class Offers {

    public double above100OfferOf5Percent(double totalPrice){

        if (totalPrice>=100){
            totalPrice = totalPrice - (totalPrice * 0.05);
        }
        else {
            totalPrice = totalPrice;
        }
        return totalPrice;
    }

    public void buy2MilkGet1FreeOffer(int milkCount){
        if (milkCount>=2){
        int count = milkCount/2;
        int totalMilkCount = milkCount+count;
        System.out.println("For "+milkCount+" packs of Milk you get "+count+" Free pack");
        }
    }


}
