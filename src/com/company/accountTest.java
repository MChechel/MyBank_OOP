package com.company;

public class accountTest {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount("Mike","123456789",1000,"0000","fixed");
        BankAccount account2 = new BankAccount("Bond","12312313",1500,"1111","fixed");
        BankAccount accountSeparate = new BankAccount("Bond_James","12312313",1500,"1111","fixed");
        BankAccount[] allAccounts = new BankAccount[]{account1,account2};
//        account1.depositMoney(500);
//        account1.withdrawMoney(333);
        Bank central_Bank = new Bank(new BankAccount[]{account1, account2},"Central bank","Panama");
        Bank PanamaBank = new Bank(new BankAccount[]{accountSeparate},"NewPanamaBank","Panama");
//
//        central_Bank.checkAccount("123456789");
       // System.out.println(account1.getAccountType());
        account1.transferMoney(central_Bank,"12312313",100);
        account2.transferMoney(PanamaBank,"12312313",250);

        System.out.println(central_Bank.getTotalMoneyInBank());
        System.out.println(central_Bank.getTotalFixedAmount());
        System.out.println(central_Bank.getTotalCurrentAmount());
        System.out.println(PanamaBank.getTotalMoneyInBank());
    }
}
