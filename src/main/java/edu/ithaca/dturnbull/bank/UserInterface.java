package edu.ithaca.dturnbull.bank;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        String usernameIn, passwordIn, emailIn, option, choice;
        Customer customer;
        Teller teller;
        tellerHuman emp1;
        double amount;

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlease choose one of the options to proceed!");
            System.out.println("1. Customer Login");
            System.out.println("2. Customer Register");
            System.out.println("3. Teller System");
            System.out.println("4. Admin System");
            System.out.print("Option: ");
            option = scan.nextLine();

            if (option.equals("1")) { // Customer Login
                System.out.println("======CUSTOMER LOGIN======");
                System.out.println("Enter your username:");
                usernameIn = scan.nextLine();
                System.out.println("Enter your password:");
                passwordIn = scan.nextLine();
                System.out.println("Enter your valid email:");
                emailIn = scan.nextLine();

                customer = Bank.getCustomer(emailIn);

                if (customer.username.equals(usernameIn)) {
                    customer = Bank.getCustomer(emailIn);
                    System.out.println("Welcome customer " + customer.username);
                    while (true) {
                        System.out.println("Welcome, " + customer.username + "! What would you like to do?");
                        System.out.println("You have " + customer.getAccounts().size() + " accounts.");

                        if (customer.getAccounts().size() == 0) {
                            System.out.println("Request a Teller to create a Savings or Checking Account for you!");
                            continue;
                        }

                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Transfer");
                        System.out.println("Type 'e' to exit out.");
                        System.out.println("Option:");
                        option = scan.nextLine();

                        if (option.equalsIgnoreCase("e")) {
                            System.out.println("Goodbye, " + customer.username + "!");
                            break;
                        }

                        if (option.equals("1")) {
                            teller = new tellerHuman();

                            //teller.deposit(account, amount);
                        }

                    }
                }

                else {
                    System.out.println("Wrong email or password! Please try again!");
                    break;
                }

            }

            else if (option.equals("2")) { // Customer Register
                System.out.println("======CUSTOMER REGISTER======");
                System.out.println("Create your username:");
                usernameIn = scan.nextLine();
                System.out.println("Create your password:");
                passwordIn = scan.nextLine();
                System.out.println("Enter your valid email:");
                emailIn = scan.nextLine();

                Bank.addLogin(emailIn, passwordIn);
                customer = new Customer(usernameIn, passwordIn, emailIn);
                Bank.allCustomer.add(customer);

            }

            else if (option.equals("3")) { // Teller System
                emp1 = new tellerHuman();

                while (true) {
                    System.out.println("Welcome employee! Please choose one of the options to proceed.");
                    System.out.println("Type 'e' to exit.");
                    System.out.println("1. Create account for a customer");
                    option = scan.nextLine();

                    if (option.equals("1")) {
                        System.out.println("Type email of the customer to create account:");
                        emailIn = scan.nextLine();
                        System.out.println("Choose which account to create.");
                        System.out.println("1. Savings");
                        System.out.println("2. Checking");
                        choice = scan.nextLine();

                        customer = Bank.getCustomer(emailIn);

                        if (customer.getAccounts().size() == 2){
                            System.out.println("Cannot create any more account for this user!");
                            continue;
                        }

                        if (choice.equals("1")) {
                            emp1.createAccount(customer, 1);
                        }

                        if (choice.equals("2")) {
                            emp1.createAccount(customer, 2);
                        }

                        else {
                            System.out.println("Invalid input, please try again!");
                        }
                    }
                }
            }

            // else if (option.equals("4")) {

            // }

            else {
                System.out.println("Invalid input! Please try again!\n");
                continue;
            }

        }
    }

}
