package com.company.bank;

public class accountTest {
    public static void main(String[] args){
        // 3 account are created
        BankAccount account1 = new BankAccount("Mike","123456789",1000,"0000","fixed");
        BankAccount account2 = new BankAccount("Bond","12312313",1500,"1111","fixed");
        BankAccount accountSeparate = new BankAccount("Bond_James","12312313",1500,"1111","fixed");
        // 2 banks are creaged here:
        Bank central_Bank = new Bank(new BankAccount[]{account1, account2},"Central bank","Panama");
        Bank PanamaBank = new Bank(new BankAccount[]{accountSeparate},"NewPanamaBank","Panama");
        // testing transfer between accounts of the same bank
        account1.transferMoney(central_Bank,"12312313",100);
        // testing transfer between accounts of different banks - the account 2 must have 5$ less than just transfer amount;
        account2.transferMoney(PanamaBank,"12312313",250);

        //counting all money in ALL accounts of bank
        System.out.println(central_Bank.getTotalMoneyInBank());
        //counting all money in "FIXED" accounts of bank
        System.out.println(central_Bank.getTotalFixedAmount());
        //counting all money in "CURRENT" accounts of bank
        System.out.println(central_Bank.getTotalCurrentAmount());
        //counting all money in ALL accounts of bank
        System.out.println(PanamaBank.getTotalMoneyInBank());
    }
}
