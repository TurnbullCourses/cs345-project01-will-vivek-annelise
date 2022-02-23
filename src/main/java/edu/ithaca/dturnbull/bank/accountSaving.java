package edu.ithaca.dturnbull.bank;


//need to change all methods to interact with daily max
public class accountSaving extends Account{
    double dailyMax;

    public accountSaving(Customer customer){
        super();
        customer.accounts.add(this);
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

}
