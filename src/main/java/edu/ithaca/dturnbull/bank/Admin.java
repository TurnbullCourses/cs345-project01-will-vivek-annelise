package edu.ithaca.dturnbull.bank;

public class Admin {

    public double getAllMoney(){
        return 0.0;
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
