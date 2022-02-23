package edu.ithaca.dturnbull.bank;

public class accountChecking extends Account {
 
    public accountChecking(Customer customer){
        super();
        customer.accounts.add(this);
    }

    public accountChecking(){
        super();
    }

}
