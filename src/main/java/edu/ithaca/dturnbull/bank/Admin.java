package edu.ithaca.dturnbull.bank;

public class Admin {

    public double getAllMoney(){
        double totalMoney = 0;
        for(Account account : Bank.getAllAccounts()){
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
    public void freezeAccount(Account account){
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
