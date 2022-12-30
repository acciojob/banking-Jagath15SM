package com.driver;

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Jagath", 15.5, 1000);
        String s = "";
        try{
            s = acc.generateAccountNumber(4, 10);
        }
        catch(Exception e){
            System.out.println("Not correct");
        }
        System.out.println(s);
    }
}