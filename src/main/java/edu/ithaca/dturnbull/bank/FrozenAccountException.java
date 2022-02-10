package edu.ithaca.dturnbull.bank;

public class FrozenAccountException extends Exception{
    private static final long serialVersionUID = 1l;

    public FrozenAccountException(String s){
        super(s);
    }

    public FrozenAccountException(){
        super("Error: account is frozen");
    }
}
