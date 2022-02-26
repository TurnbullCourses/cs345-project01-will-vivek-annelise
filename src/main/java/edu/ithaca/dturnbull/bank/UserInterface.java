package edu.ithaca.dturnbull.bank;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        String usernameIn, passwordIn, emailIn, option;
        Customer customer;
        Bank bank = new Bank();

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("\nPlease choose one of the options to proceed!");
            System.out.println("1. Login as Customer");
            System.out.println("2. Register Customer Account");
            System.out.print("Option: ");
            option = scan.nextLine();

            if (option.equals("1")) {
                // System.out.println("Logging in!");
                System.out.println("=======================");
                // System.out.println("size of allcustomers: " + Bank.allCustomer.size());
                System.out.println("Enter your username:");
                usernameIn = scan.nextLine();
                System.out.println("Enter your password:");
                passwordIn = scan.nextLine();
                System.out.println("Enter your email:");
                emailIn = scan.nextLine();

                // System.out.println("emailIn: " + emailIn);
                // System.out.println("passwordIn: " + passwordIn);
                // System.out.println("checkLogin: " + Bank.checkLogin(emailIn, passwordIn));

                // Encountering a problem around here. checkLogin is returning false when it
                // shouldn't, though the unit test (UserInterfaceTest.java) works properly.

                if (Bank.checkLogin(emailIn, passwordIn)) {
                    System.out.println("Successfully logged in! Welcome, customer " + usernameIn);
                }

                else {
                    System.out.println("Wrong email or password!");
                }

            }

            else if (option.equals("2")) {
                // System.out.println("Registering!");
                System.out.println("=======================");

                System.out.println("Create your username:");
                usernameIn = scan.nextLine();
                System.out.println("Create your password:");
                passwordIn = scan.nextLine();
                System.out.println("Enter your email:");
                emailIn = scan.nextLine();

                if (Bank.allLogins.containsValue(emailIn)) {
                    System.out.println("User already exists with that email, please try again!");
                    continue;
                }

                System.out.println("Successfully registered!");
                customer = new Customer(usernameIn, passwordIn, emailIn);
                Bank.allCustomer.add(customer);
            }

            else {
                System.out.println("Invalid input! Please try again!\n");
                continue;
            }

        }
    }

}