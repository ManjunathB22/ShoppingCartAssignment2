package com.ultralesson.objectorientation.services;

public class EWallet {
    private double balance;

    public EWallet(double balance) {
        this.balance = balance;
    }

    public double getWalletBalance() {
        return balance;
    }

    public double addBalance(double amount) {
        balance = balance + amount;
        return balance;
    }

    public double deductBalance(double deductAmount) throws Exception {
        if (balance > deductAmount) {
            balance = balance - deductAmount;
            return balance;
        } else
            throw new Exception("Balance Insufficient, Please add Money to wallet");
    }
}