package com.example.bank;

public abstract class Account {

    public Person person ;
    public Double balance;
    public String cardNumber ;

    Account(Person inputPerson, String inputCardNumber, Double inputBalance){
        person = inputPerson ;
        cardNumber = inputCardNumber ;
        balance = inputBalance ;
    }
    public void whithdraw( Double money ){
        balance -= money;
    }
    public void deposit( Double money ){
        balance += money;
    }
    public abstract void calculateBenefit();

}
