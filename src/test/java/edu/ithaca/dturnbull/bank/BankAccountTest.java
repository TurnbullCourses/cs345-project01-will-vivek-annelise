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
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        // Teller.deposit(0); not working
        bankAccount.deposit(0); // test for withdrawing 0
        assertEquals(200, bankAccount.getBalance(), 0.001);
        bankAccount.deposit(50);    //add
        assertEquals(250, bankAccount.getBalance(), 0.001);
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-100)); // negative amount
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(1.234)); // decimal
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