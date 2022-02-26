package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserInterfaceTest {

    @Test
    public void UserInterfaceTest(){

        assertEquals(0, Bank.allCustomer.size());

        Customer testCustomer = new Customer("test1", "123", "test@mail.com");
        Bank.allCustomer.add(testCustomer);

        assertEquals(1, Bank.allCustomer.size());

        assertTrue(Bank.checkLogin("test@mail.com", "123"));
    }
    
}
