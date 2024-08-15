package com.kunal.examples.datamanipulation;

public class Account {

    private double balance =100;

   boolean withdraw(double amount) throws IllegalAccessException
   {
       if ((balance-amount)>= 0)
       {
           balance -= amount;
           System.out.println(("withdrawl succefull balance is "+balance));
           return true;
       }

       return false;
   }

   public boolean overdraft() throws IllegalAccessException {
       balance+=300;
       System.out.println("Added back-up amount 300 new balance "+balance);
       return true;
   }

   public static void main(String str[]) throws IllegalAccessException {
       Account acc = new BankAccount();
       boolean withdrawn = acc.withdraw(200);
       System.out.println("Withdrawn succefull "+ withdrawn);
       if (!withdrawn)
       {
           acc.overdraft();
       }
       acc.withdraw(200);
   }
}
