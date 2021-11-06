package com.company;

import java.util.Arrays;

public class Bank {
    private BankAccount[] mainAccounts;

    public BankAccount[] getMainAccounts() {
        return mainAccounts;
    }

    public void setMainAccounts(BankAccount[] mainAccounts) {
        this.mainAccounts = mainAccounts;
    }
    private String name;
    private String location;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public Bank(BankAccount[] mainAccounts, String name, String location) {
        this.mainAccounts = mainAccounts;
        this.name = name;
        this.location = location;
    }

    public boolean checkAccount(String accountNumber){
        for (BankAccount a:mainAccounts){
            if (accountNumber.equals(a.getAccountNumber())){
                System.out.println("Account exists!");
                return true;
            }else{
                System.out.println("Wrong account number!");
            }

        }
        return false;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "mainAccounts=" + Arrays.toString(mainAccounts) +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
