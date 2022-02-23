package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AccountTest {
    
    @Test
    public void amountValidTest() throws IllegalArgumentException{
        
        assertThrows(IllegalArgumentException.class, () -> Account.amountValid(10.111));

        assertThrows(IllegalArgumentException.class, () -> Account.amountValid(-1));
    }

    @Test
    public void isFrozenTest() throws FrozenAccountException{
        Account tAccount = new accountChecking();
        Admin.freeze(tAccount);
        assertThrows(IllegalArgumentException.class, () -> Account.isFrozen(tAccount));
    }

    @Test
    public void withdrawDepositTest() throws IllegalArgumentException, FrozenAccountException, InsufficientFundsException{
        Account tAccount = new accountChecking();

        assertEquals(0, tAccount.getBalance());

        tAccount.deposit(100);

        assertEquals(100, tAccount.getBalance());

        tAccount.withdraw(50);

        assertEquals(50, tAccount.getBalance());

        tAccount.deposit(1.50);

        assertEquals(51.5, tAccount.getBalance());

        assertThrows(InsufficientFundsException.class, () -> tAccount.withdraw(1000));
    }

    @Test
    public void transferTest() throws IllegalArgumentException, FrozenAccountException{
        Account tAccount1 = new accountChecking();
        Account tAccount2 = new accountChecking();

        tAccount1.deposit(100);
        tAccount1.transfer(50, tAccount2);

        assertEquals(50, tAccount1.getBalance());
        assertEquals(50, tAccount2.getBalance());

    }

}
