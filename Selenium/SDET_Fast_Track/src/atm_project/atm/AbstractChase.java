package atm_project.atm;

import atm_project.exceptions.*;
import atm_project.main.Account;
import atm_project.main.Data;

import java.util.Scanner;

public abstract class AbstractChase extends ATM {

    protected AbstractChase(double withdrawLimit) {
        super(withdrawLimit);
        turnOn();
    }

    @Override
    public void turnOn() {
        for (int i=0; i<5; i++){
            System.out.println("ATM booting up...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        setPowerOn(true);
        Data.loadAccounts();
    }

    @Override
    public void turnOff() {
        System.out.println("ATM shutting down");
        setPowerOn(false);
        Data.allAccounts.clear();
    }

    @Override
    public void login(String userName, int pin) {
        for (Account each : Data.allAccounts) {
            if (each.getUserName().equals(userName)) {
                if (each.getPin() == pin) {
                    Data.currentAccount = each;
                    System.out.println("Logged In");
                    break;
                } else {
                    throw new InvalidPinException();
                }
            }
            throw new UserNotFoundException("Username not found");
        }
     }
    @Override
    public void logout () {
        System.out.println("Logged Out");
        Data.currentAccount = null;

    }

    @Override
    public double withdraw(double amount) {
        if (amount<= getWithdrawLimit()){
            if (amount<= Data.currentAccount.getBalance()){
                System.out.println("Withdrawing $"+amount);

                Data.currentAccount.updateBalance(-amount);

            }else {
                throw new NotEnoughMoneyException("Withdraw Failure");
            }

        }else {
            throw new WithdrawLimitException();
        }
        return Data.currentAccount.getBalance();
    }

    @Override
    public double checkBalance() {
        return Data.currentAccount.getBalance();
    }

    @Override
    public double deposit(double amount) {
        System.out.println("Adding $ "+amount+" into "+Data.currentAccount.getAccountNumber());
        return Data.currentAccount.getBalance();
    }

    @Override
    public boolean transfer(long accountNumber, double amount) {
        for (Account each : Data.allAccounts) {
            if (each.getAccountNumber()==accountNumber){
               if (Data.currentAccount.getBalance()>=amount){
                   System.out.println("Transfering $"+amount+" to "+accountNumber);
                 each.updateBalance(amount);
                 Data.currentAccount.updateBalance(-amount);
                 return true;
               }else {
                   throw new NotEnoughMoneyException("Cannot transfer $"+amount+" , not enough in balance");
               }
            }
        }
        throw new UserNotFoundException("Cannot Transfer to this account");
    }

    @Override
    public void interfaceMenue(Scanner input) {
        if (!isPowerOn()){
            throw new PowerNotFoundException();
        }
        if (Data.currentAccount==null){
            System.out.println("Pleace login first");
            return;
        }
        System.out.println("1) Check Blance\n2)Deposit\3)Withdraw\n4)Transfer\n5)Logout");

        switch (input.nextInt()){
            case 1:
                System.out.println(checkBalance());
                break;
            case 2:
                System.out.println("How much will you deposit?");
                deposit(input.nextDouble());
                break;
            case 3:
                System.out.println("How much will you withdraw?");
                withdraw(input.nextDouble());
                break;
            case 4:
                System.out.println("Pleace enter the account number you want to, and then amount you want to transfer");
                transfer(input.nextLong(),input.nextDouble());
                break;
            case 5:
                logout();
            default:
                System.out.println("Not a valid option, Pleace try again");
        }
    }
}