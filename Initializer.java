package Coding;

import Coding.model.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Initializer {
    public static HashMap<Integer,Customer> initialize() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\91758\\IdeaProjects\\Java\\src\\Coding\\bank_db.txt"));
        HashMap<Integer,Customer> allCustomers = new HashMap<>();
        Customer customer;
        String currentLine = "";

        while((currentLine = reader.readLine()) != null){
            String currArray[] = currentLine.split(" ");

            customer = new Customer();
            int custId = Integer.parseInt(currArray[0]);
            int accountNumber = Integer.parseInt(currArray[1]);
            String name = currArray[2];
            int balance = Integer.parseInt(currArray[3]);
            String encryptedPassword = currArray[4];

            customer.setCustId(custId);
            customer.setAccountNumber(accountNumber);
            customer.setName(name);
            customer.setBalance(balance);
            customer.setEncryptedPassword(encryptedPassword);
            allCustomers.put(custId, customer);
        }
        reader.close();
        return allCustomers;
    }
}
