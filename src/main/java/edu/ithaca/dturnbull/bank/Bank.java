package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

public class Bank {
    // Account[] allAcounts;
    // Teller[] allTellers;
    // Admin[] allAdmin;

    ArrayList<Account> allAccounts = new ArrayList<Account>();
    ArrayList<Teller> allTellers = new ArrayList<Teller>();
    ArrayList<Admin> allAdmin = new ArrayList<Admin>();


    /**
     * @param account
     * @post adds to database of all accounts in system
     */
    public void addToAllAccounts(Account account){
        allAccounts.add(account);
    }

    /**
     * @param account
     * @post adds to database of all tellers in system
     */
    public void addToAllTellers(Teller teller){
        allTellers.add(teller);
    }

    /**
     * @param account
     * @post adds to database of all admin in system
     */
    public void addToAllAdmin(Admin admin){
        allAdmin.add(admin);
    }
}
