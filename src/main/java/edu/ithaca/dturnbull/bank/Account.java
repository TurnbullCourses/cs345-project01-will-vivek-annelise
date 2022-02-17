package edu.ithaca.dturnbull.bank;

public abstract class Account {
    int accountNum;
    double balance;
    boolean frozen;

    public Account(){
        accountNum = 0; //should be random 
        balance = 0; //start with no money
        frozen = false; //account starts open
    }
    

    /**
     * @param amount
     * @throws FrozenAccountException
     * @throws IllegalArgumentException
     */
    public void deposit(double amount) throws FrozenAccountException, IllegalArgumentException{
        amountValid(amount);
        isFrozen(this);
        balance+= amount;
    }

    /**
     * @param amount
     * @throws FrozenAccountException
     * @throws IllegalArgumentException
     */
    public void withdraw(double amount)throws FrozenAccountException, IllegalArgumentException{

    }

    /**
     * @throws IllegalArgumentException
     * @returns false if negative or has 2 decimal places
     */
    public static void amountValid(double amount) throws IllegalArgumentException{
        //check for negative
        if(amount < 0){
            throw new IllegalArgumentException("amount must be positive");
        }
        
        //check for decimal place
        String amountString = Double.toString(amount);
        if(amountString.indexOf(".") < amountString.length() - 3){
            throw new IllegalArgumentException("amount must have no more than 2 decimal places");
        }
    }
    /**
     * @param account
     * @throws FrozenAccountException
     */
    public static void isFrozen(Account account) throws FrozenAccountException{
        if (account.frozen == true){
            throw new FrozenAccountException();
        }
    }
}