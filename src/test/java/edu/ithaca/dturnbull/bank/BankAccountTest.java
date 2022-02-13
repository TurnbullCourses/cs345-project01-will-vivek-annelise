package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BankAccountTest {

    @Test
    void getBalanceTest() throws IllegalArgumentException, FrozenAccountException {
        Account account1 = new Account();
        assertEquals(0, Teller.getBalance(account1), 0.001);

        Teller.deposit(account1, 200);
        assertEquals(200, Teller.getBalance(account1), 0.001);
    }

    @Test
    void withdrawTest() throws InsufficientFundsException, FrozenAccountException{
        Account bankAccount = new Account();
        // Withdrawing amount on an account that has 0 balance. 
        assertThrows(InsufficientFundsException.class, () -> Teller.withdraw(bankAccount, 100)); 

        // Depositing 204.56 dollars, and withdrawing 100 dollars from it for a balance of 104.56 dollars
        Teller.deposit(bankAccount, 204.56);
        Teller.withdraw(bankAccount, 100);
        assertEquals(104.56, Teller.getBalance(bankAccount));

        // Withdrawing more than what you already have should throw InsufficientFundsException
        assertThrows(InsufficientFundsException.class, () -> Teller.withdraw(bankAccount, 300));
        
        Account bankAccount2 = new Account();
        // Withdrawing amount on an account with no balance
        Teller.withdraw(bankAccount2, 0);
        assertEquals(0, Teller.getBalance(bankAccount2), 0.001); 
        assertThrows(InsufficientFundsException.class, () -> Teller.withdraw(bankAccount, 100));

        // Checking for negative amount, and amount with more than 2 decimal places
        assertThrows(IllegalArgumentException.class, () -> Teller.withdraw(bankAccount2, -100));
        assertThrows(IllegalArgumentException.class, () -> Teller.withdraw(bankAccount2, 1.234));
    }

    @Test
    void depositTest() throws IllegalArgumentException, FrozenAccountException{
        Account bankAccount = new Account();

        // Depositing zero amount to the account
        Teller.deposit(bankAccount, 0);
        assertEquals(0, bankAccount.balance, 0.001);

        // Depositing 50 dollars to the account
        Teller.deposit(bankAccount, 50);
        assertEquals(50, bankAccount.balance, 0.001);

        // Checking for negative amount, and amount with more than 2 decimal places
        assertThrows(IllegalArgumentException.class, () -> Teller.deposit(bankAccount, -100));
        assertThrows(IllegalArgumentException.class, () -> Teller.deposit(bankAccount, 1.234));
    }

    
    @Test
    void transferTest() throws InsufficientFundsException, IllegalArgumentException, FrozenAccountException{
        Account bankAccountFrom = new Account();
        Account bankAccountTo = new Account();

        Teller.deposit(bankAccountFrom, 150);
        Teller.deposit(bankAccountTo, 250);
        Teller.transfer(bankAccountFrom, bankAccountTo, 50);
        assertEquals(100, Teller.getBalance(bankAccountFrom), 0.001);
        assertEquals(300, Teller.getBalance(bankAccountTo), 0.001);

        // Transferring more than what you already have
        assertThrows(InsufficientFundsException.class, () -> Teller.transfer(bankAccountFrom, bankAccountTo, 300));

        // Transferring negative amount & amount w/ more than 2 decimal places
        assertThrows(IllegalArgumentException.class, () -> Teller.transfer(bankAccountFrom, bankAccountTo, -100));
        assertThrows(IllegalArgumentException.class, () -> Teller.transfer(bankAccountFrom, bankAccountTo, 1.234));

    }

    @Test
    void freezeAccountTest() throws IllegalArgumentException, FrozenAccountException, InsufficientFundsException{
        Account account1 = new Account();
        Account account2 = new Account();

        Teller.deposit(account1, 300);
        assertEquals(300, Teller.getBalance(account1));

        // Cannot perform deposit, and withdraw on a frozen account 
        Teller.freezeAccount(account1);
        assertThrows(FrozenAccountException.class, ()-> Teller.deposit(account1, 1300));
        assertEquals(300, Teller.getBalance(account1));
        assertThrows(FrozenAccountException.class, ()-> Teller.withdraw(account1, 300));
        assertEquals(300, Teller.getBalance(account1));

        // Cannot perform transfer on a frozen account(s)
        // account1 is frozen, account2 is unfrozen
        assertThrows(FrozenAccountException.class, ()-> Teller.transfer(account1, account2, 250)); 
        assertEquals(300, Teller.getBalance(account1));
        assertEquals(0, Teller.getBalance(account2));

        // account1 is unfrozen, account2 is frozen
        Teller.freezeAccount(account2); 
        assertThrows(FrozenAccountException.class, ()-> Teller.transfer(account1, account2, 100));
        assertEquals(300, Teller.getBalance(account1));
        assertEquals(0, Teller.getBalance(account2));

        // both account1 and account2 are frozen
        assertThrows(FrozenAccountException.class, ()-> Teller.transfer(account1, account2, 100));
        assertEquals(300, Teller.getBalance(account1));
        assertEquals(0, Teller.getBalance(account2));

        // Performing deposit, withdraw, and transfer on unfrozen account(s)
        Teller.unfreezeAccount(account1);
        Teller.unfreezeAccount(account2);
        Teller.deposit(account1, 300);
        assertEquals(600, Teller.getBalance(account1));
        Teller.withdraw(account1, 50);
        assertEquals(550, Teller.getBalance(account1));
        Teller.transfer(account1, account2, 100);
        assertEquals(450, Teller.getBalance(account1));
        assertEquals(100, Teller.getBalance(account2));
    }

    @Test
    void amountValidTest(){
        assertTrue(Teller.amountValid(12.34)); // valid
        assertTrue(Teller.amountValid(12)); // whole number
        assertTrue(Teller.amountValid(12.3)); // less than 2 decimals
        assertFalse(Teller.amountValid(12.345)); // too many decimals
        assertFalse(Teller.amountValid(-12.34)); // negative value
    }

    // @Test
    // void isEmailValidTest(){
    //     assertTrue(BankAccount.isEmailValid( "a@b.com"));   // valid email address
    //     assertFalse( BankAccount.isEmailValid(""));         // empty string        
    // }

    // @Test
    // void constructorTest() {
    //     Account account1 = new Account();

    //     assertEquals("a@b.com", bankAccount.getEmail());
    //     assertEquals(200, bankAccount.getBalance(), 0.001);
    //     //check for exception thrown correctly
    //     assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    // }

}