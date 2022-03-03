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
    /**
     * @returns list of all suspicious accounts (frozen)
     */
    public static ArrayList<Account> getReport(){
        ArrayList<Account>susAcc = new ArrayList<>();
        for(Account account : Bank.allAccounts){
            if(account.frozen == true){
                susAcc.add(account);
            }
        }
        return susAcc;
    }


    /**
     * @param account
     * @post freezes account
     */
    public static void freeze(Account account){
        account.frozen = true;
    }

    /**
     * @param account
     * @post unfreezes account
     */
    public static void unfreeze(Account account){
        account.frozen = false;
    }

}
