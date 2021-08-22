package com.greatlearning.services;

import com.greatlearning.models.Customer;

import java.util.Scanner;

public class BankingService {

    Scanner sc = new Scanner(System.in);
    int bankBalance =  1000;
    public void logout() {
        System.out.println("You are logged out now");
    }

    public void deposit(Customer customer){
        int amount;
        System.out.println("Enter the deposit amount");
        amount = sc.nextInt();
        if (amount > 0 ) {
            System.out.println("Amount deposited successfully");
            customer.setBalance(customer.getBalance() + amount);
            System.out.println("Total Balance is : "+ customer.getBalance());
        } else System.out.println("Please provide valid Input");
    }

    public void withdrawl(Customer customer1, String type) {
        int amount;
        System.out.println("Enter the "+type +"amount");
        amount = sc.nextInt();
        if (customer1.getBalance() >= amount ) {
            System.out.println(type + "is successful \n");
            customer1.setBalance(customer1.getBalance() - amount);
            System.out.println("Total Balance is : "+ customer1.getBalance());
        } else System.out.println("Insufficient funds");
    }

    public void transfer(Customer customer1, String type) {
        int otp,otpGenerated,toAccountNumber;
        OtpService otpService = new OtpService();
        otpGenerated = otpService.generateOtp();
        System.out.println("------Generated OTP is -----");
        System.out.println(otpGenerated);
        System.out.println("Enter the  OTP");
        otp = sc.nextInt();

        if(otp == otpGenerated) {
            System.out.println("OTP successful");
            System.out.println("Enter amount to be transferred");
            System.out.println("Enter Account ");
            toAccountNumber = sc.nextInt();
            withdrawl(customer1, type);
        }
    }
}
