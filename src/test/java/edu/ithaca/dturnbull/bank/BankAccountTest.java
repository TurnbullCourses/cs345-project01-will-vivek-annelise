package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance(), 0.001);
    }

    @Test
    void withdrawTest() throws InsufficientFundsException{
        //change to Teller.withdraw
        Account bankAccount = new Account();
        Teller.withdraw(bankAccount, 100);

        assertEquals(100, bankAccount.balance, 0.001);
        assertThrows(InsufficientFundsException.class, () -> Teller.withdraw(bankAccount, 300));
        
        Teller.withdraw(bankAccount, 0); // test for withdrawing 0
        assertEquals(200, bankAccount.balance, 0.001);
        Teller.withdraw(bankAccount, 100); // test for proper withdrawl
        assertThrows(IllegalArgumentException.class, () -> Teller.withdraw(bankAccount, -100)); // negative amount - boarder case
        assertThrows(IllegalArgumentException.class, () -> Teller.withdraw(bankAccount, 1.234)); // decimal
    }

    @Test
    void depositTest(){
        Account bankAccount = new Account();

        // Teller.deposit(0); not working
        Teller.deposit(bankAccount, 0); // test for withdrawing 0
        assertEquals(200, bankAccount.balance, 0.001);
        Teller.deposit(bankAccount, 50);    //add
        assertEquals(250, bankAccount.balance, 0.001);
        assertThrows(IllegalArgumentException.class, () -> Teller.withdraw(bankAccount, -100)); // negative amount
        assertThrows(IllegalArgumentException.class, () -> Teller.withdraw(bankAccount, 1.234)); // decimal
    }

    
    @Test
    void transferTest() throws InsufficientFundsException{
        Account bankAccount = new Account();
        Account bankAccount2 = new Account();

        Teller.deposit(bankAccount, 150);
        Teller.deposit(bankAccount2, 250);
        Teller.transfer(bankAccount, bankAccount2, 50); //valid transfer
        
        assertEquals(200, bankAccount.balance, 0.001);
        assertThrows(InsufficientFundsException.class, () -> Teller.transfer(bankAccount, bankAccount2, 300)); //withdraw too much
        assertThrows(IllegalArgumentException.class, () -> Teller.transfer(bankAccount, bankAccount2, -100)); // negative amount
        assertThrows(IllegalArgumentException.class, () -> Teller.transfer(bankAccount, bankAccount2, 1.234)); // decimal

    }

    @Test
    void freezeAccountTest(){
        Account account1 = new Account();

        Teller.deposit(account1, 300);

        assertEquals(300, Teller.getBalance(account1));

        Teller.freezeAccount(account1);

        assertThrows(FrozenAccountException.class, ()-> Teller.deposit(account1, 1300));
        assertThrows(FrozenAccountException.class, ()-> Teller.withdraw(account1, 300));

        Account account2 = new Account();
        assertThrows(FrozenAccountException.class, ()-> Teller.transfer(account1, account2, 250));

        Teller.unfreezeAccount(account1);
        Teller.deposit(account1, 300);
        assertEquals(600, Teller.getBalance(account1));
    }

    @Test
    void amountValidTest(){
        //change to Teller
        assertTrue(BankAccount.amountValid(12.34)); //valid
        assertTrue(BankAccount.amountValid(12)); // whole number
        assertTrue(BankAccount.amountValid(12.3)); //less than 2 decimals
        assertFalse(BankAccount.amountValid(12.345));   //too many decimals
        assertFalse(BankAccount.amountValid(-12.34));   //negative value
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));   // valid email address
        assertFalse( BankAccount.isEmailValid(""));         // empty string

        
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance(), 0.001);
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}