package com.company;

import java.util.Scanner;

public class BankAccount {
    private String name;
    private String accountNumber;
    private float accountAmount;
    private String bankName;
    private String pinCode;
    private boolean accStatus = true;

    public BankAccount() {
    }
    public BankAccount(String name, String accountNumber, float accountAmount, String bankName, String pinCode) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountAmount = accountAmount;
        this.bankName = bankName;
        this.pinCode = pinCode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public float getAccountAmount() {
        return accountAmount;
    }
    public void setAccountAmount(float accountAmount) {
        this.accountAmount = accountAmount;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getPinCode() {
        return pinCode;
    }
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public void depositMoney(float amount){
        //each method will ahve to check if account is active or blocked
        if (this.accStatus){
        System.out.println("You are depositing - "+amount);
        Scanner scanner = new Scanner(System.in);
        boolean currentOperation = false;
        System.out.print("Plase enter your pin-code here:");
        if (!currentOperation){
        for (int i = 0; i < 3; i++) {
        if (scanner.next().equals(this.pinCode)){
        System.out.println(amount+" was added to your account.");
           this.accountAmount+=amount;
            currentOperation=true;
            break;
        }else{
            System.out.println("You entered wrong code, you have "+(2-i)+" tries left");
        }
        }
        }
        if (!currentOperation){
        this.accStatus = false;
        System.out.println("Your account has been blocked - please contact your bank");
        }
        }else{
            System.out.println("Your account is blocked, please contact your bank!");
        }

    }
    public void withdrawMoney(float amount){
        //each method will have to check if account is active or blocked
        if (this.accStatus){
            System.out.println("You are withdrawing - "+amount);
            Scanner scanner = new Scanner(System.in);
            boolean currentOperation = false;
            System.out.print("Please, enter your pin-code here:");
            if (!currentOperation){
                for (int i = 0; i < 3; i++) {
                    if (scanner.next().equals(this.pinCode)){
                        System.out.println(amount+" was withdrawn from your account.");
                        this.accountAmount-=amount;
                        currentOperation=true;
                        break;
                    }else{
                        System.out.println("You entered wrong code, you have "+(2-i)+" tries left");
                    }
                }
            }
            if (!currentOperation){
                this.accStatus = false;
                System.out.println("Your account has been blocked - please contact your bank");
            }
        }else{
            System.out.println("Your account is blocked, please contact your bank!");
        }
    }
    public void transferMoney(String accountNumber,float amount){

    }


}
