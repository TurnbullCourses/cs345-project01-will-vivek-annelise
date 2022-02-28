package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BankTest {
    
    @Test
    public void checkLoginTest(){
        Customer tCustomer = new Customer("username", "password123", "person@domain.com");
        
        assertTrue(Bank.checkLogin("person@domain.com", "password123"));
        assertFalse(Bank.checkLogin("email", "password1234"));
    }

    @Test
    public void getCustomerTest(){
        Customer tCustomer = new Customer("username", "password123", "person@domain.com");

        Bank.allCustomer.add(tCustomer);

        tCustomer = Bank.getCustomer("person@domain.com");
        
        assertEquals("username", tCustomer.username);

    }
}
