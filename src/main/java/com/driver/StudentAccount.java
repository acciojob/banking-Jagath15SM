package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    private String name;
    private double balance;
    private double minBalance;

    public StudentAccount(String name, double balance, String  institutionName) {
        //minimum balance is 0 by default
        super(name, balance, 0);

        this.name = name;
        this.balance = balance;



        this.institutionName = institutionName;

    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }
}
