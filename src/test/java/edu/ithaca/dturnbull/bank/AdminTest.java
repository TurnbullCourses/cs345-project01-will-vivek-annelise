package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

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

        //-------------------------------------------------------------//

        assertEquals(60, Admin.getAllMoney());
    }

    @Test
    void freezeGetReportTest(){
        //test freezeAcc and getReport
        Customer customer = new Customer("c1", "p1", "a@b.c");
        accountSaving account1 = new accountSaving(customer);
        Admin.freeze(account1);

        Customer customer2 = new Customer("c2", "p2", "b@b.c");
        accountChecking account2 = new accountChecking(customer2);
        Admin.freeze(account2);

        Customer customer3 = new Customer("c3", "p3", "c@b.c");
        accountSaving account3 = new accountSaving(customer3);
        Admin.freeze(account3);

        //-------------------------------------------------------------//
        ArrayList<Account> myArray = new ArrayList<Account>();
        myArray.add(account1);
        myArray.add(account2);
        myArray.add(account3);

        assertEquals(myArray, Admin.getReport());
        //-------------------------------------------------------------//
        //test unfreezeAcc
        myArray.remove(account2);
        Admin.unfreeze(account2);
        
        assertEquals(myArray, Admin.getReport());
    }
}
