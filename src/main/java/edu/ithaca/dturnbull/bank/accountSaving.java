package edu.ithaca.dturnbull.bank;

public class accountSaving extends Account{
    double dailyMax;

    public accountSaving(Customer customer){
        super();
        customer.accounts.add(this);
    }

    public double getIntrest(){
        return -1;
    } 

    public boolean compareMax(double val){
        return false;
    }

}
