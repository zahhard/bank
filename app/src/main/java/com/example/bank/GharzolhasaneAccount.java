package com.example.bank;

public class GharzolhasaneAccount extends Account {

    GharzolhasaneAccount(Person inputPerson, String inputCardNumber, Double inputBalance) {
        super(inputPerson, inputCardNumber, inputBalance);
    }

    @Override
    public void calculateBenefit() {
        balance = balance;
    }
}
