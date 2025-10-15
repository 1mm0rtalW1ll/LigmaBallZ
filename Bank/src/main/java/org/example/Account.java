package org.example;
import java.util.Date;

public class Account {
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0; // в процентах
    private Date dateCreated;

    public Account() {
        this.dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterest() {
        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        return balance * monthlyInterestRate;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Недостаточно средств для снятия.");
        } else if (amount <= 0) {
            System.out.println("Сумма для снятия должна быть положительной.");
        } else {
            balance -= amount;
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Сумма для пополнения должна быть положительной.");
        } else {
            balance += amount;
        }
    }
}
