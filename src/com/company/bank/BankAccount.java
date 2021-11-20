package com.company.bank;

import com.company.Person;

import java.util.Scanner;

public class BankAccount {
    private Person customer;
    private String accountNumber;
    private float accountAmount;
    private String bankName;
    private String pinCode;
    private boolean accStatus = true;

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        accountType = accountType.toLowerCase();
        if ((accountType.equals("current"))|(accountType.equals("savings"))|(accountType.equals("fixed"))){
        this.accountType = accountType;
        }else System.out.println("Please check the account type...you entered wrong value");
    }
    private String accountType;
    public BankAccount() {
    }
    public BankAccount(Person customer, String accountNumber, float accountAmount, String pinCode,String accountType) {
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.accountAmount = accountAmount;
        this.bankName = bankName;
        this.pinCode = pinCode;
        accountType = accountType.toLowerCase();
        if ((accountType.equals("current"))|(accountType.equals("savings"))|(accountType.equals("fixed"))){
            this.accountType = accountType;
        }else System.out.println("Please check the account type...you entered wrong value");
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
        this.bankName =bankName;
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
    public void depositMoney(float amount,String code){
        //it is silent deposit for transfer method;
        if (this.accStatus){
                    if (code.equals(this.pinCode)){
                        this.accountAmount+=amount;
                    }
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
    public void transferMoney(Bank theBank,String accountNumber,float amount) {
       if (this.accStatus){
    for (BankAccount a:theBank.getMainAccounts()){
        //System.out.println(a.toString());
        if (a.getAccountNumber().equals(accountNumber)){
            // updated - now include charge if the banks are different
            if (this.getBankName().equals(a.getBankName())){
                this.setAccountAmount(this.accountAmount-amount);
            }   else this.setAccountAmount(this.accountAmount-amount-theBank.getCharge());
            System.out.println("The account name is "+this.getCustomer()+". New amount is "+this.getAccountAmount());
            a.depositMoney(amount,a.getPinCode());
            System.out.println("The account name is "+a.getCustomer()+". New amount is "+a.getAccountAmount());
        }
    }
       }else {
           System.out.println("Your account is blocked, please contact your bank!");
       }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + customer + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountAmount=" + accountAmount +
                ", bankName='" + bankName + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", accStatus=" + accStatus +
                '}';
    }
}
