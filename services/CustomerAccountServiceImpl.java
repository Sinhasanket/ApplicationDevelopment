package Coding.services;

import Coding.model.Customer;

import java.io.*;
import java.util.HashMap;

public class CustomerAccountServiceImpl implements CustomerAccountService{
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void withdrawAmount(Customer customer) throws Exception{
        System.out.println("Enter the Amount to be Withdrawn");
        int amount = Integer.parseInt(reader.readLine());
        int customerBalance = customer.getBalance();
        int reducedBalance = customerBalance - amount;
        if (customerBalance > 1000 && reducedBalance > 1000){
            customer.setBalance(reducedBalance);
            updateDatabase(customer,null,reducedBalance,0);
            System.out.println("Amount Withdrawn Succesfully");
        }else {
            System.out.println("Insufficient Amount");
        }
    }

    @Override
    public void depositAmount(Customer customer) throws Exception{
        System.out.println("Enter the Amount to be credited");
        int addAmount = Integer.parseInt(reader.readLine());
        int oldAmount = customer.getBalance();
        int newAmount = oldAmount + addAmount;
        customer.setBalance(newAmount);
        updateDatabase(customer,null,newAmount,0);
        System.out.println("Amount Deposited");
    }

    @Override
    public void transferAmount(HashMap<Integer, Customer> allCustomers, Customer customer) throws Exception {
        System.out.println("Enter Benificery CustomerId Number");
        int toAccountNumber = Integer.parseInt(reader.readLine());
        System.out.println("Enter Amount to Transfer");
        int transferAmount = Integer.parseInt(reader.readLine());
        Customer beneficiaryCustomer = allCustomers.get(toAccountNumber);
        if (beneficiaryCustomer != null){
            int oldAmount = customer.getBalance() - transferAmount;
            if (oldAmount > 1000){
                customer.setBalance(oldAmount);
                int newAmount = beneficiaryCustomer.getBalance();
                int newBalance = newAmount + transferAmount;
                beneficiaryCustomer.setBalance(newBalance);
                updateDatabase(customer,beneficiaryCustomer,oldAmount,newBalance);
                System.out.println("Money Transferred");
            }else {
                System.out.println("Insufficient Balance");
            }
        }else {
            System.out.println("Enter Correct Benificery Account Number");
        }
    }

    public static void updateDatabase(Customer customer, Customer beneficiary, int newAmount, int benNew) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\91758\\IdeaProjects\\Java\\src\\Coding\\bank_db.txt"));
        String currentLine = "";
        StringBuilder builder = new StringBuilder();
        while ((currentLine = reader.readLine()) != null) {
            String arr[] = currentLine.split(" ");
            if (currentLine.contains(customer.getCustId() + "")) {
                arr[3] = newAmount+"";
                currentLine = "";
                for (String changed : arr){
                    currentLine += changed+" ";
                }
            }
            if (beneficiary != null && currentLine.contains(beneficiary.getCustId()+"")){
                arr[3] = benNew+"";
                currentLine = "";
                for (String changed : arr){
                    currentLine += changed+" ";
                }
            }
            builder.append(currentLine).append("\n");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\91758\\IdeaProjects\\Java\\src\\Coding\\bank_db.txt"));
        writer.write(builder.toString());
        writer.flush();
        writer.close();
    }
}