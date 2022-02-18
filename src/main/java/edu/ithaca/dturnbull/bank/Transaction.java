package edu.ithaca.dturnbull.bank;

public class Transaction {
    double amount;
    String date;
    String type;

    public Transaction(double amount, String date, String type){
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    @Override
    public String toString(){
        return type + "Amount: " + amount + "Date: " + date;
    }

}
