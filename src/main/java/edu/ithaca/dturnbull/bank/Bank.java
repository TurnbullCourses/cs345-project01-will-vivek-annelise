package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    static ArrayList<Account> allAccounts = new ArrayList<Account>();
    static ArrayList<Teller> allTellers = new ArrayList<Teller>();
    static ArrayList<Admin> allAdmin = new ArrayList<Admin>();
    static ArrayList<Customer> allCustomer = new ArrayList<Customer>();
    static HashMap<String, String> allLogins = new HashMap<String, String>();

    public static void addLogin(String email, String password){
        Bank.allLogins.put(password, email);
    }

    public static boolean checkLogin(String email, String password){
        if (allLogins.get(password) == email){
            return true;
        } else {
            return false;
        }
    }

    public static Customer getCustomer(String email){
        for (Customer temp : allCustomer){
            if (temp.getEmail() == email){
                return temp;
            }
        }
        return null;

    }
}