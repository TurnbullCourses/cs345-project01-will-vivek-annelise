package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AdminTest {
    @Test
    void allMoneyTest(){
        //create customer and an acc
        Customer customer = new Customer("c1", "p1", "a@b.c");
        accountSaving account1 = new accountSaving(customer);
        account1.balance = 10;

        Customer customer2 = new Customer("c2", "p2", "b@b.c");
        accountChecking account2 = new accountChecking(customer2);
        account2.balance = 20;

        Customer customer3 = new Customer("c3", "p3", "c@b.c");
        accountSaving account3 = new accountSaving(customer3);
        account3.balance = 30;

        assertEquals(60, Admin.getAllMoney());
    }

    @Test
    void reportTest(){
        
    }
}
