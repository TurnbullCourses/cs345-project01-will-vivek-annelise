package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

public class Customer {
    
    String password;
    String username;
    String email;
    //Account[] accounts;

    ArrayList<Account> accounts = Bank.allAccounts;
}
