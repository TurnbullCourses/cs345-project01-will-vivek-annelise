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
        this.dailyMax = 1000;
    }

    public double getDailyMax(){
        return dailyMax;
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

    @Override
    public void withdraw(double amount) throws IllegalArgumentException, FrozenAccountException, InsufficientFundsException{
        this.dailyMax -= amount;
        super.withdraw(amount);
    }

    @Override
    public void transfer(double amount, Account target) throws FrozenAccountException{
        this.dailyMax -= amount;
        super.transfer(amount, target);
    }


}
