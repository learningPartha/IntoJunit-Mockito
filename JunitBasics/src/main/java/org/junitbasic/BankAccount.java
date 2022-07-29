package org.junitbasic;

public class BankAccount {

    private static double balance = 15000;

    public static void main(String[] args) throws InsufficientFundException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw(1000.00);
        bankAccount.withdraw(20000.00);
    }

    public void withdraw(double amt) throws InsufficientFundException {
        System.out.println("Total remaining balance: "+balance);
        if(balance>=amt){
            System.out.println("After withdrawal of "+amt+" remaining balance: "+balance);
        }
        else{
            throw new InsufficientFundException("Insufficent balance : withdrawal amount "+amt+
                    " greater than remaining balance "+balance);
        }
    }
}
