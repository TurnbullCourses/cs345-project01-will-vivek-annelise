package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void transactionTest() throws IllegalArgumentException, FrozenAccountException, InsufficientFundsException {
        Account tAccount = new accountChecking();

        tAccount.deposit(100);
        assertEquals("deposit, Amount: 100.0, Date: " + java.time.LocalDate.now(), tAccount.transactions.get(0).toString());

        tAccount.withdraw(10);
        assertEquals("withdraw, Amount: 10.0, Date: " + java.time.LocalDate.now(), tAccount.transactions.get(1).toString());

        Account tAccount2 = new accountChecking();

        tAccount.transfer(50, tAccount2);
        assertEquals("transferTo, Amount: 50, Date: " + java.time.LocalDate.now() + ", Target: tAccount2", tAccount.transactions.get(2).toString()); //how to check this
        assertEquals("transferFrom, Amount: 50, Date: " + java.time.LocalDate.now() + ", Target: tAccount", tAccount.transactions.get(2).toString()); //how to check this
    }
}
