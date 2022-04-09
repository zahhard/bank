package com.example.bank;

public class SavingAccount extends Account {


    SavingAccount(Person inputPerson, String inputCardNumber, Double inputBalance) {
        super(inputPerson, inputCardNumber, inputBalance);
    }

    @Override
    public void calculateBenefit() {
        balance = balance * 1.1;
    }
}
