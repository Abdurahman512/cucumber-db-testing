package atm_project.main;

public class Account {

    private String userName;
    private long accountNumber;
    private double balance;
    private int pin;

    public Account(String userName, long accountNumber, double balance, int pin) {
        this.userName = userName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public void updateBalance(double money){
        balance+= money;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return accountNumber+" | "+userName+" | $ "+balance;
    }

    @Override
    public boolean equals(Object obj){
        return this.userName.equals(((Account)obj).userName);
    }


}
