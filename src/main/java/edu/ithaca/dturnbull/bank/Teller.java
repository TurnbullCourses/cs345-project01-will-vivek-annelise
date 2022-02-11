package edu.ithaca.dturnbull.bank;

public class Teller {
    

    public double getBalance(Account account){
        return account.balance;
    }

    public static void deposit(Account account, double amount) throws FrozenAccountException{
        checkFrozen(account);
        if(amountValid(amount) == false){
            throw new IllegalArgumentException();
        }

        account.balance+= amount;
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
     * @param amount
     * @throws FrozenAccountException
     * @post checks if account is frozen
     */
    public static void checkFrozen(Account account) throws FrozenAccountException{
        if(account.frozen == true){
            throw new FrozenAccountException();
        }
    }

    /**
     * @throws InsufficientFundsException
     * @throws FrozenAccountException
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public static void withdraw(Account account, double amount) throws InsufficientFundsException, FrozenAccountException{
        checkFrozen(account);
        if(amountValid(amount) == false){
            throw new IllegalArgumentException("invalid withdrawl amount");
        }
        if (amount <= account.balance){
            account.balance -= amount;
        }
        if (amount > account.balance){
            throw new InsufficientFundsException("Not enough money");
        }
    }

    public static void transfer(Account accountTo, Account accountFrom, double amount) throws InsufficientFundsException, FrozenAccountException{
        checkFrozen(accountTo);
        checkFrozen(accountFrom);
        if(amountValid(amount) == false){
            throw new IllegalArgumentException();
        }
        if (amount > accountFrom.balance){
            throw new InsufficientFundsException("Not enough money");
        }
        else{
            withdraw(accountFrom, amount);
            deposit(accountTo, amount);
        }
    }

    public void freezeAccount(Account account){
        account.frozen = true;

    }

    public void unfreezeAccount(Account account){
        account.frozen = false;

    }

}
