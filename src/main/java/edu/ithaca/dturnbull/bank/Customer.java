package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

public class Customer {
    
    String password;
    String username;
    String email;
    ArrayList<Account> accounts;

    public Customer(){
        String password = null;
        String username = null;
        String email = null;
        ArrayList<Account> accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

}
