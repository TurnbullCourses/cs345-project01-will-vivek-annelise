package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

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
    }


    public ArrayList<Account> getAccounts(){
        return accounts;
    }

}
