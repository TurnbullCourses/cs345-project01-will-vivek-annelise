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
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance(), 0.001);
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(300));
        
        bankAccount.withdraw(0); // test for withdrawing 0
        assertEquals(200, bankAccount.getBalance(), 0.001);
        bankAccount.withdraw(100); // test for proper withdrawl
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-100)); // negative amount - boarder case
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(1.234)); // decimal
    }

    @Test
    void depositTest(){
        Account bankAccount = new Account();

        // Teller.deposit(0); not working
        Teller.deposit(bankAccount, 0); // test for withdrawing 0
        assertEquals(200, bankAccount.balance, 0.001);
        bankAccount.deposit(bankAccount, 50);    //add
        assertEquals(250, bankAccount.balance, 0.001);
        assertThrows(IllegalArgumentException.class, () -> Teller.withdraw(bankAccount, -100)); // negative amount
        assertThrows(IllegalArgumentException.class, () -> Teller.withdraw(bankAccount, 1.234)); // decimal
    }

    
    @Test
    void transferTest() throws InsufficientFundsException{
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        BankAccount bankAccount2 = new BankAccount("a@b.com", 200);

        //Change to Teller.transfer
        bankAccount.transfer(50, bankAccount2); //valid transfer
        assertEquals(150, bankAccount.getBalance());
        assertEquals(250, bankAccount2.getBalance());

        assertThrows(InsufficientFundsException.class, () -> bankAccount.transfer(300, bankAccount2)); //withdraw too much
        assertThrows(IllegalArgumentException.class, () -> bankAccount.transfer(-100, bankAccount2)); // negative amount
        assertThrows(IllegalArgumentException.class, () -> bankAccount.transfer(1.234, bankAccount2)); // decimal

    }

    @Test
    void freezeAccount(){
        BankAccount account = new BankAccount("a@b.com", 200);
        account.deposit(100);
        assertEquals(300, account.getBalance());

        Teller.freezeAccount(account);

        assertThrows(FrozenAccountException.class, ()-> account.deposit(1300));
        assertThrows(FrozenAccountException.class, ()-> account.withdraw(300));

        BankAccount account2 = new BankAccount("a@b.com", 0);
        assertThrows(FrozenAccountException.class, ()-> account.transfer(250, account2));

        Teller.unfreezeAccount(account);
        account.deposit(300);
        assertEquals(600, account.getBalance());
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