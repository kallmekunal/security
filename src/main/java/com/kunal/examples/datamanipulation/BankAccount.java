package com.kunal.examples.datamanipulation;

public class BankAccount extends  Account{

    @Override
    boolean withdraw(double amount) throws IllegalAccessException
    {
        if (!securityCheck()){
            throw new IllegalAccessException();
        }
        return super.withdraw(amount);
    }

    private boolean securityCheck() {
        return true;
    }

    @Override
    public boolean overdraft() throws IllegalAccessException {
        if (!securityCheck()){
            throw new IllegalAccessException();
        }
        super.overdraft();
        return true;
    }

}
