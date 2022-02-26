package edu.ithaca.dturnbull.bank;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        String usernameIn, passwordIn, emailIn, option;
        Customer customer;
        Bank bank = new Bank();

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("Please choose one of the options to proceed!");
            System.out.println("1. Login");
            System.out.println("2. Register");
            option = scan.nextLine();

            if (option.equals("1")) {
                System.out.println("Logging in!");

                System.out.println("Enter your username: ");
                usernameIn = scan.nextLine();
                System.out.println("Enter your password: ");
                passwordIn = scan.nextLine();
                System.out.println("Enter your email: ");
                emailIn = scan.nextLine();

                if(Bank.checkLogin(emailIn, passwordIn)){
                    System.out.println("Successfully logged in!");
                }

                else {
                    System.out.println("Wrong email or password!");
                }

            }

            else if (option.equals("2")) {
                System.out.println("Registering!");

                System.out.println("Create your username: ");
                usernameIn = scan.nextLine();
                System.out.println("Create your password: ");
                passwordIn = scan.nextLine();
                System.out.println("Enter your email: ");
                emailIn = scan.nextLine();

                if(Bank.checkLogin(emailIn, passwordIn)){
                    System.out.println("User already exists!");
                    break;
                }

                else {
                    System.out.println("Successfully registered!");
                    customer = new Customer(usernameIn, passwordIn, emailIn);
                    Bank.allCustomer.add(customer);
                }
            }

            else {
                System.out.println("Invalid input! Please try again!\n");
                continue;
            }

        }
    }

}