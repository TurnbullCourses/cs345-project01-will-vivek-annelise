package edu.ithaca.dturnbull.bank;

public class tellerHuman extends Teller{
    
    public void createAccount(Customer customer, int choice){
        
        accountChecking checking = new accountChecking();
        accountSaving saving = new accountSaving();

        if (choice == 1){
            customer.accounts.add(saving);
        }

        else if (choice == 2){
            customer.accounts.add(checking);
        }
    }
    
    public void closeAccount(Account account){

    }
}
