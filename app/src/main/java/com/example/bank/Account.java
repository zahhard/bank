package com.example.bank;

import java.util.SplittableRandom;

public class Account {

    public String type ;
    public Double balance;
    public String cardNumber ;

    Account(String inputType, String inputCardNumber, String inputBalance){
        type = inputType;
        cardNumber = inputCardNumber ;
        balance = Double.parseDouble(inputBalance) ;
    }
    public void whithdraw( String money ){  balance  -= Double.parseDouble(money); }
    public void deposit( String money ){  balance  += Double.parseDouble(money); }
    public void calculateBenefit(){};
}
