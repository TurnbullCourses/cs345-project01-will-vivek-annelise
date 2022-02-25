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
        Account tAccount2 = new accountChecking();
        Admin.freeze(tAccount);
        assertThrows(FrozenAccountException.class, () -> Account.isFrozen(tAccount));
        assertThrows(FrozenAccountException.class, () -> tAccount.withdraw(100));
        assertThrows(FrozenAccountException.class, () -> tAccount.transfer(10, tAccount2));
        assertThrows(FrozenAccountException.class, () -> tAccount2.transfer(10, tAccount));
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

    @Test
    public void accountSavingTest() throws IllegalArgumentException, FrozenAccountException, InsufficientFundsException{
        accountSaving tAccount = new accountSaving();
        tAccount.deposit(1000);

        assertEquals(1000, tAccount.getDailyMax());

        tAccount.withdraw(100);

        assertEquals(900, tAccount.getDailyMax());

        tAccount.transfer(450, new accountChecking());

        assertEquals(450, tAccount.getDailyMax());

    }

}
