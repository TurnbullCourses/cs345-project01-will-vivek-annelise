package edu.ithaca.dturnbull.bank;

import java.time.LocalDate;

public class Transaction {
    double amount;
    LocalDate date;
    String type;

    public Transaction(double amount, LocalDate date, String type){
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    @Override
    public String toString(){
        return type + ", Amount: " + amount + ", Date: " + date;
    }

}
