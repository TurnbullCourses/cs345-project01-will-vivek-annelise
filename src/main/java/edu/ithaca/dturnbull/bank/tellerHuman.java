package edu.ithaca.dturnbull.bank;

public class tellerHuman extends Teller{
    
    public void createAccount(Customer customer){

        //TODO: Find a way to add checking + savings to a customer
        
        accountChecking checking = new accountChecking();
        accountSaving saving = new accountSaving();

        customer.accounts.add(checking);
        customer.accounts.add(saving);

    }
    
    public void closeAccount(Account account){

    }
}
