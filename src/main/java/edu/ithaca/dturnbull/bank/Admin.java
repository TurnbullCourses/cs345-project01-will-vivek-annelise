package edu.ithaca.dturnbull.bank;

public class Admin {

    static public double getAllMoney(){
        double totalMoney = 0;
        for(Account account : Bank.allAccounts){
            totalMoney+=account.balance;
        }
        return totalMoney;
    }

    public String getReport(Account account){
        String report = "";
        for(Transaction transaction : account.transactions){
            report.concat(transaction.toString());
        }
        return report;
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
