package Coding.util;

import Coding.model.Customer;

import java.util.Map;

public class Printer {
    public static void print(Map<Integer,Customer> allCustomers){
        StringBuilder printUser = new StringBuilder();
        for (Map.Entry customer : allCustomers.entrySet()){
            int customerId = (int) customer.getKey();
            Customer printCustomer = (Customer) customer.getValue();
            printUser.append(customerId).append(" ");
            printUser.append(printCustomer.getAccountNumber()).append(" ");
            printUser.append(printCustomer.getName()).append(" ");
            printUser.append(printCustomer.getEncryptedPassword()).append("\n");
        }
        System.out.println(printUser.toString());
    }
}