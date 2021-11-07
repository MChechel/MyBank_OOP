package com.company.bank;

import java.util.Arrays;
public class Bank {
    public Bank(BankAccount[] mainAccounts, String name, String location) {
        this.mainAccounts = mainAccounts;
        this.name = name;
        this.location = location;
        //now account bank name is added during adding instances to bank
        for (BankAccount a:mainAccounts){
            a.setBankName(name);
        }
    }

    private BankAccount[] mainAccounts;
    private String name;
    private float charge = 5;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMainAccounts(BankAccount[] mainAccounts) {
        this.mainAccounts = mainAccounts;
    }
    public BankAccount[] getMainAccounts() {
        return mainAccounts;
    }
    public float getCharge() {
        return charge;
    }
    public void setCharge(float charge) {
        this.charge = charge;
    }

    //unused at the moment
    private String location;
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

// checks if account is blocked or not...
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
//main methods will be here:
//    getTotalMoneyInBank;
//    getTotalSavingsAmount;
//    getTotalCurrentAmount
//    getTotalFixedAmount
//"current" "savings" "fixed"
public float getTotalMoneyInBank(){
        float totalAmount = 0;
        for (BankAccount a:mainAccounts){
            totalAmount += a.getAccountAmount();
        }
        return totalAmount;
}
    public float getTotalSavingsAmount(){
        float totalSavingsAmount = 0;
        for (BankAccount a:mainAccounts){
            totalSavingsAmount += a.getAccountType()=="savings"?a.getAccountAmount():0;
        }
        return totalSavingsAmount;
    }
    public float getTotalCurrentAmount(){
        float totalCurrentAmount = 0;
        for (BankAccount a:mainAccounts){
            totalCurrentAmount += a.getAccountType()=="current"?a.getAccountAmount():0;
        }
        return totalCurrentAmount;
    }
    public float getTotalFixedAmount(){
        float totalFixedAmount = 0;
        for (BankAccount a:mainAccounts){
            totalFixedAmount += a.getAccountType()=="fixed"?a.getAccountAmount():0;
        }
        return totalFixedAmount;
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
