package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TellerTest {

    //TODO: Resolve issue with the Account abstract class

    @Test
    void getBalanceTest() throws IllegalArgumentException, FrozenAccountException {
         
        Account account1 = new Account();
        ATM atm1 = new ATM();

        assertEquals(0, atm1.getBalance(account1));

        atm1.deposit(account1, 200);
        assertEquals(200, atm1.getBalance(account1), 0.001);
    }

    @Test
    void withdrawTest() throws InsufficientFundsException, FrozenAccountException{
        Account account = new Account();
        ATM atm1 = new ATM();

        // withdrawing on an empty account 
        assertThrows(InsufficientFundsException.class, () -> atm1.withdraw(account, 100)); 

        atm1.deposit(account, 204.56);
        atm1.withdraw(account, 100);
        assertEquals(104.56, atm1.getBalance(account));

        // Withdrawing more than what you already have should throw InsufficientFundsException
        assertThrows(InsufficientFundsException.class, () -> atm1.withdraw(account, 300));
        
        Account account2 = new Account();
        ATM atm2 = new ATM();
        // Withdrawing amount on an account with no balance
        atm2.withdraw(account2, 0);
        assertEquals(0, atm2.getBalance(account2), 0.001); 
        assertThrows(InsufficientFundsException.class, () -> atm2.withdraw(account2, 100));

        // Checking for negative amount, and amount with more than 2 decimal places
        assertThrows(IllegalArgumentException.class, () -> atm2.withdraw(account2, -100));
        assertThrows(IllegalArgumentException.class, () -> atm2.withdraw(account2, 1.234));
    }

    @Test
    void depositTest() throws IllegalArgumentException, FrozenAccountException{
        Account bankAccount = new Account();
        tellerHuman human1 = new tellerHuman();

        // depositing nothing
        human1.deposit(bankAccount, 0);
        assertEquals(0, bankAccount.balance, 0.001);

        human1.deposit(bankAccount, 50);
        assertEquals(50, bankAccount.balance, 0.001);

        // checking for negative amount, and amount with more than 2 decimal places
        assertThrows(IllegalArgumentException.class, () -> human1.deposit(bankAccount, -100));
        assertThrows(IllegalArgumentException.class, () -> human1.deposit(bankAccount, 1.234));
    }

    
    @Test
    void transferTest() throws InsufficientFundsException, IllegalArgumentException, FrozenAccountException{
        Account bankAccountFrom = new Account();
        Account bankAccountTo = new Account();
        ATM atm1 = new ATM();

        atm1.deposit(bankAccountFrom, 150);
        atm1.deposit(bankAccountTo, 250);
        atm1.transfer(bankAccountFrom, bankAccountTo, 50);
        assertEquals(100, atm1.getBalance(bankAccountFrom), 0.001);
        assertEquals(300, atm1.getBalance(bankAccountTo), 0.001);

        // transferring more than what you already have
        assertThrows(InsufficientFundsException.class, () -> atm1.transfer(bankAccountFrom, bankAccountTo, 300));

        // transferring negative amount & amount w/ more than 2 decimal places
        assertThrows(IllegalArgumentException.class, () -> atm1.transfer(bankAccountFrom, bankAccountTo, -100));
        assertThrows(IllegalArgumentException.class, () -> atm1.transfer(bankAccountFrom, bankAccountTo, 1.234));

    }

    @Test
    void createAccountTest() {
        tellerHuman human1 = new tellerHuman();
        Customer customer1 = new Customer();

        // customer1 should have no accounts
        assertEquals(0, customer1.accounts.size());

        human1.createAccount(customer1);

        // customer1 should have 2 accounts (checking and savings)
        assertEquals(2, customer1.accounts.size());

    }
    
}
