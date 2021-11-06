package com.company;

public class accountTest {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount("Mike","123456789",1000,"Central bank","0000");
        BankAccount account2 = new BankAccount("Bond","12312313",1500,"Central bank","1111");
        BankAccount[] allAccounts = new BankAccount[]{account1,account2};
//        account1.depositMoney(500);
//        account1.withdrawMoney(333);
        Bank central_Bank = new Bank(new BankAccount[]{account1, account2},"Central bank","Panama");
//        central_Bank.checkAccount("123456789");

        account1.transferMoney(central_Bank,"12312313",250);

    }
}
