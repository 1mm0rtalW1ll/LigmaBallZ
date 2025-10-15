package org.example;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[10];
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i, 10000);
        }
        Account.setAnnualInterestRate(6.5);

        while (true) {
            int id = -1;
            while (true) {
                System.out.print("Введите ID: ");
                if (scanner.hasNextInt()) {
                    id = scanner.nextInt();
                    if (id >= 0 && id < 10) {
                        break;
                    } else {
                        System.out.println("Некорректный ID. Попробуйте снова.");
                    }
                } else {
                    System.out.println("Пожалуйста, введите число.");
                    scanner.next();
                }
            }

            Account currentAccount = accounts[id];
            boolean exitMenu = false;

            while (!exitMenu) {
                System.out.println("Основное меню");
                System.out.println("1: проверить баланс счета");
                System.out.println("2: снять со счета");
                System.out.println("3: положить на счет");
                System.out.println("4: выйти");
                System.out.print("Введите пункт меню: ");

                int choice = -1;
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                } else {
                    System.out.println("Введите число от 1 до 4.");
                    scanner.next();
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Баланс равен " + currentAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Введите сумму для снятия со счета: ");
                        if (scanner.hasNextDouble()) {
                            double withdrawAmount = scanner.nextDouble();
                            if (withdrawAmount <= 0) {
                                System.out.println("Сумма должна быть положительной.");
                            } else if (withdrawAmount > currentAccount.getBalance()) {
                                System.out.println("Недостаточно средств.");
                            } else {
                                currentAccount.withdraw(withdrawAmount);
                            }
                        } else {
                            System.out.println("Введите корректное число.");
                            scanner.next();
                        }
                        break;
                    case 3:
                        System.out.print("Введите сумму для пополнения счета: ");
                        if (scanner.hasNextDouble()) {
                            double depositAmount = scanner.nextDouble();
                            if (depositAmount <= 0) {
                                System.out.println("Сумма должна быть положительной.");
                            } else {
                                currentAccount.deposit(depositAmount);
                            }
                        } else {
                            System.out.println("Введите корректное число.");
                            scanner.next();
                        }
                        break;
                    case 4:
                        exitMenu = true;
                        break;
                    default:
                        System.out.println("Некорректный выбор. Попробуйте снова.");
                }
            }
        }
    }
}
