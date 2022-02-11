package edu.ithaca.dturnbull.bank;

public class Teller {
    private double balance;

    public double getBalance(Account account){
        return account.balance;
    }

    public void deposit(double amount){
        
    }


    /**
     * @param amount
     * @throws IllegalArgumentException
     * @post checks if negative or has 2 decimal places
     */
    public static boolean amountValid(double amount){
        //check for negative
        if(amount < 0){
            return false;
        }
        
        //check for decimal place
        String amountString = Double.toString(amount);
        if(amountString.indexOf(".") < amountString.length() - 3){
            return false;
        }

        return true;
    }

    /**
     * @throws InsufficientFundsException
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw(double amount) throws InsufficientFundsException{
        if(amountValid(amount) == false){
            throw new IllegalArgumentException("invalid withdrawl amount");
        }
        if (amount <= balance){
            balance -= amount;
        }
        if (amount > balance){
            throw new InsufficientFundsException("Not enough money");
        }
    }

    public void transfer(Account to, Account from, double amount){

    }

    public void freezeAccount(Account account){

    }

    public void unfreezeAccount(Account account){

    }

}
