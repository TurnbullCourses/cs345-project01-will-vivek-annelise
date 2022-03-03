package edu.ithaca.dturnbull.bank;

import java.time.LocalDate;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import java.util.ArrayList;


public abstract class Account {
    int accountNum;
    double balance;
    boolean frozen;
    ArrayList<Transaction> transactions;

    public Account(){
        accountNum = 0; //should be random 
        balance = 0; //start with no money
        frozen = false; //account starts open
        transactions = new ArrayList<Transaction>();
    }
    
    /**
     * @return balance 
     */
    public double getBalance(){
        return balance;
    }

    @Override
    public String toString(){
        return Integer.toString(accountNum);
    }

    /**
     * @param amount
     * @throws FrozenAccountException
     * @throws IllegalArgumentException
     */
    public void deposit(double amount) throws FrozenAccountException, IllegalArgumentException{
        amountValid(amount);
        isFrozen(this);
        balance += amount;
        transactions.add(new Transaction(amount, java.time.LocalDate.now(), "deposit"));
    }

    /**
     * @param amount
     * @throws FrozenAccountException
     * @throws IllegalArgumentException
     * @throws InsufficientFundsException
     */
    public void withdraw(double amount)throws FrozenAccountException, IllegalArgumentException, InsufficientFundsException{
        amountValid(amount);
        isFrozen(this);
        if (amount > balance){
            throw new InsufficientFundsException("Insufficient Funds");
        }
        balance -= amount;
        transactions.add(new Transaction(amount, java.time.LocalDate.now(), "withdraw"));
    }


    public void transfer(double amount, Account target) throws FrozenAccountException{
        amountValid(amount);
        isFrozen(this);
        isFrozen(target, "target account is frozen"); 
        balance -= amount;
        target.balance += amount;
        transactions.add(new Transaction(amount, java.time.LocalDate.now(), "transferTo", target));
        target.transactions.add(new Transaction(amount, java.time.LocalDate.now(), "transferFrom", this));
    }

    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    /**
     * @throws IllegalArgumentException if amount is less than 0 or if it has too many decimals
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

    /**
     * @param account
     * @throws FrozenAccountException
     */
    public static void isFrozen(Account account, String text) throws FrozenAccountException{
        if (account.frozen == true){
            throw new FrozenAccountException(text);
        }
    }
}