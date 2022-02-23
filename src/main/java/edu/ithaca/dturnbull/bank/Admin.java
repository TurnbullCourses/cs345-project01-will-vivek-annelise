package edu.ithaca.dturnbull.bank;

public class Admin {


    public Admin(){
        
    }

    public double getAllMoney(){
        double totalMoney = 0;
        for(Account account : Bank.allAccounts){
            totalMoney+=account.balance;
        }
        return totalMoney;
    }

    public int[] getReport(Account account){
        return null;
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
