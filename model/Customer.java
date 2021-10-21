package Coding.model;

public class Customer implements Comparable<Customer>{
    private int custId;
    private int accountNumber;
    private String name;
    private int balance;
    private String encryptedPassword;

    public Customer(){

    }

    public Customer(int oldCustomerId, int oldAccountNumber){
        this.custId = oldCustomerId + 1;
        this.accountNumber = oldAccountNumber + 10;
        this.balance = 1000;
    }
    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    @Override
    public int compareTo(Customer o) {
        return o.balance - this.balance;
    }
}
