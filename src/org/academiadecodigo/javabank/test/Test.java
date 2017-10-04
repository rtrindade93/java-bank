package org.academiadecodigo.javabank.test;

public class Test {

    public static void main(String[] args) {

        AccountTest accountTest = new AccountTest();
        CustomerTest customerTest = new CustomerTest();
        BankTest bankTest = new BankTest();
        SavingsAccountTest savingsAccountTest = new SavingsAccountTest();
        CheckingAccountTest checkingAccountTest = new CheckingAccountTest();

        System.out.println("Account: " + (accountTest.test() ? "OK" : "FAIL"));
        System.out.println("Customer: " + (customerTest.test() ? "OK" : "FAIL"));
        System.out.println("Bank: " + (bankTest.test() ? "OK" : "FAIL"));
        System.out.println("Savings Account: " + (savingsAccountTest.test() ? "OK" : "FAIL"));
        System.out.println("Checking Account: " + (checkingAccountTest.test() ? "OK" : "FAIL"));

    }


}
