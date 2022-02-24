package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

public class Admin {

    static public double getAllMoney(){
        double totalMoney = 0;
        for(Account account : Bank.allAccounts){
            totalMoney+=account.balance;
        }
        return totalMoney;
    }

<<<<<<< HEAD
    public String getReport(Account account){
        String report = "";
        for(Transaction transaction : account.transactions){
            report.concat(transaction.toString());
        }
        return report;
=======
    public ArrayList<Transaction> getReport(Account account){
        return account.transactions;
>>>>>>> main
    }


    /**
     * @param account
     * @post freezes account
     */
    public void freeze(Account account){
        account.frozen = true;
    }

    /**
     * @param account
     * @post unfreezes account
     */
    public void unfreeze(Account account){
        account.frozen = false;
    }

}
