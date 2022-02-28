package edu.ithaca.dturnbull.bank;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        String usernameIn, passwordIn, emailIn, option;
        Customer customer;

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("\nPlease choose one of the options to proceed!");
            System.out.println("1. Login as Customer");
            System.out.println("2. Register Customer Account");
            System.out.print("Option: ");
            option = scan.nextLine();

            if (option.equals("1")) {
                System.out.println("=======================");
                System.out.println("Enter your username:");
                usernameIn = scan.nextLine();
                System.out.println("Enter your password:");
                passwordIn = scan.nextLine();
                System.out.println("Enter your email:");
                emailIn = scan.nextLine();


                //TODO: Resolve issue with accessing customer inside this while loop. 

                Bank.addLogin(emailIn, passwordIn);

                if (Bank.checkLogin(emailIn, passwordIn)) {
                    customer = Bank.getCustomer(emailIn);
                    System.out.println("Successfully logged in! Welcome, customer " + customer.username);
                }

                else {
                    System.out.println("Wrong email or password!");
                }

            }

            else if (option.equals("2")) {
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