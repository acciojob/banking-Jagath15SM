package com.driver;

import java.util.ArrayList;
import java.util.List;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    private String name;
    private double balance;
    private double minBalance = 5000;

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        this.name = name;
        this.balance = balance;
        if(balance < minBalance){
            throw new Exception("Insufficient Balance");
        }
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if (!isValid(tradeLicenseId)) {
            List<String> permutations = permute(tradeLicenseId);
            for (String permutation : permutations) {
                if (isValid(permutation)) {
                    tradeLicenseId = permutation;
                    return;
                }
            }
            throw new Exception("Valid License can not be generated");
        }
    }

    private List<String> permute(String str) {
        List<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }
        for (int i = 0; i < str.length(); i++) {
            String remaining = str.substring(0, i) + str.substring(i + 1);
            List<String> subPermutations = permute(remaining);
            for (String permutation : subPermutations) {
                permutations.add(str.charAt(i) + permutation);
            }
        }
        return permutations;
    }

    public boolean isValid(String tradeLicenseId){

        for(int i=0;i<tradeLicenseId.length()-1;i++){
            if(tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i+1)){
                return false;
            }
        }

        return true;
    }

    // Getters


    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getMinBalance() {
        return minBalance;
    }
}

