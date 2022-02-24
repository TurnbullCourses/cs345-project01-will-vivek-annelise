package edu.ithaca.dturnbull.bank;

import java.time.LocalDate;

public class Transaction {
    double amount;
    LocalDate date;
    String type;
    Account target;

    public Transaction(double amount, LocalDate date, String type){
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.target = null;
    }

    public Transaction(double amount, LocalDate date, String type, Account target){
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.target = target;
    }

    @Override
    public String toString(){
        if (target == null){
            return type + ", Amount: " + amount + ", Date: " + date;
        } else {
            return type + ", Amount: " + amount + ", Date: " + date + ", Target: " + target;   
        }
    }

}
