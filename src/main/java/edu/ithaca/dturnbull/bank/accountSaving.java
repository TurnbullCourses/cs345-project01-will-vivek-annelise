package edu.ithaca.dturnbull.bank;


//need to change all methods to interact with daily max
public class accountSaving extends Account{
    double dailyMax;

    public accountSaving(Customer customer){
        super();
        dailyMax = 1000;
        customer.accounts.add(this);
        Bank.allAccounts.add(this);
    }

    public accountSaving(Customer customer, double max){
        super();
        dailyMax = max;
        customer.accounts.add(this);
        Bank.allAccounts.add(this);

    }

    public accountSaving(){
        super();
    }

    public double getIntrest(){
        return balance * .01;
    } 

    public boolean compareMax(double val){
        if (val > dailyMax) {
            return false;
        } else {
            dailyMax -= val;
            return true;
        }
    }

    public void setDailyMax(int amount){
        this.dailyMax = amount;
    }

    public void withdraw(double amount){
        this.withdraw(amount);
        this.dailyMax -= amount;
    }

    public void transfer(double amount, Account target){
        this.transfer(amount, target);
        this.dailyMax -= amount;
    }


}
