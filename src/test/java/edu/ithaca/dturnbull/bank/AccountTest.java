package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AccountTest {
    
    @Test
    public void amountValidTest() throws IllegalArgumentException{
        
        assertThrows(IllegalArgumentException.class, () -> Account.amountValid(10.111));

        assertThrows(IllegalArgumentException.class, () -> Account.amountValid(0));
    }

    @Test
    public void isFrozenTest() throws FrozenAccountException{

        //need admin to free for these tests 
        
        assertThrows(IllegalArgumentException.class, () -> Account.frozen(10.111));
    }

}
