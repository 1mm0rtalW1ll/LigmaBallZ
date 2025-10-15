package org.example;


public class Main {
    public static void main(String[] args) {
        Account account = new Account(1155, 300000);
        Account.setAnnualInterestRate(6.5);

        account.withdraw(16500);

        account.deposit(50000);

        System.out.println("Баланс: " + account.getBalance() + " руб.");
        System.out.println("Ежемесячные проценты: " + account.getMonthlyInterest() + " руб.");
        System.out.println("Дата создания счета: " + account.getDateCreated());
    }
}
