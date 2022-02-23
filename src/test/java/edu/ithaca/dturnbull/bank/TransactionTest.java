package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void depositTransactionTest() throws IllegalArgumentException, FrozenAccountException{
        Customer tCustomer = new Customer();
        Account tAccount = new accountChecking(tCustomer);

        tAccount.deposit(100);

        assertEquals("deposit, Amount: 100, Date: " + java.time.LocalDate.now(), tAccount.getTransactions().toString());

    }
}
