package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    String password;
    String username;
    String email;
    ArrayList<Account> accounts;

    public Customer(String username, String password, String email){
        this.password = password;
        this.username = username;
        this.email = email;
        this.accounts = new ArrayList<Account>();
        Bank.addLogin(email, password);
        Bank.allCustomers.add(this);
        ArrayList<Account> accounts = new ArrayList<Account>();
    }


    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    public String getEmail(){
        return email;
    }
}
