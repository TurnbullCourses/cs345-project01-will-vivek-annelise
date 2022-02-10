package edu.ithaca.dturnbull.bank;

public class Account {
    int accountNum;
    double balance;
    boolean frozen;

    public Account(){
        accountNum = 0; //should be random 
        balance = 0; //start with no money
        frozen = false; //account starts open
    }
}
