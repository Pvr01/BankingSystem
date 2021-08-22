package com.greatlearning.main;

import com.greatlearning.models.Customer;
import com.greatlearning.services.BankingService;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        BankingService bankingService = new BankingService();
        Customer customer1 = new Customer("pwd1", 1234);

        Scanner scanner = new Scanner(System.in);
        String password;
        int bankAccountNo;
        System.out.println("Welcome to login page \n");
        System.out.println("Enter your Account Number\n");
        bankAccountNo = scanner.nextInt();
        System.out.println("Enter your Password");
        password = scanner.next();

        Customer validateLogin = new Customer(password, bankAccountNo);

        if (validateCustomer(validateLogin, customer1)) {
            int option =0;
            do {
                System.out.println("\n -------------------------------");
                System.out.println("1. Deposit");
                System.out.println("2. WithDrawl");
                System.out.println("3. Transfer");
                System.out.println("4. Logout \n ---------------------");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        bankingService.deposit(customer1);
                        break;
                    case 2:
                        bankingService.withdrawl(customer1, "Withdraw");
                        break;
                    case 3:
                        bankingService.transfer(customer1, "Transfer");
                        break;
                    case 4:
                        bankingService.logout();
                        break;
                    default: throw new IllegalStateException("Enter valid input");

                }
            } while (option != 4);

        } else {
            System.out.println("Enter valid Login credentials");
        }
    }

    private static boolean validateCustomer(Customer validateLogin, Customer customer1) {
        return validateLogin.getBankAccountNo() == customer1.getBankAccountNo() && validateLogin.getPassword().equals(customer1.getPassword());
    }
}
