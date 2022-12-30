package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;


    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        if (sum > 9 * digits) {
            throw new Exception("Account Number can not be generated");
        }

        if (digits == 0) {
            return "";
        } else if (sum == 0) {
            String result = "";
            for (int i = 0; i < digits; i++) {
                result += "0";
            }
            return result;
        } else {
            // recursive case: try adding each possible digit to the account number
            for (int i = 0; i < 10; i++) {
                try {
                    // generate the rest of the account number with the remaining sum and digits
                    String rest = generateAccountNumber(digits-1, sum-i);
                    // if successful, return the result with the current digit added to the front
                    return i + rest;
                } catch (Exception e) {
                    // if an exception is thrown, catch it and try the next digit
                    continue;
                }
            }
            // if all possible digits have been tried and no valid account number was found, throw an exception
            throw new Exception("Account Number can not be generated");
        }
    }

    public void deposit(double amount) {
        //add amount to balance
        if(amount <= 0) return;
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance >= amount){
            balance -= amount;
        }

        if(balance < minBalance){
            throw new Exception("Insufficient Balance");
        }
    }

    // Getters


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