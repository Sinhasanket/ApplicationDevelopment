package Coding.util;

import Coding.model.Customer;

import java.util.Map;

public class Printer {
    public static void print(Map<Integer,Customer> allCustomers){
        for (Map.Entry customer : allCustomers.entrySet()){
            int customerId = (int) customer.getKey();
            Customer printCustomer = (Customer) customer.getValue();
            System.out.println(customerId+" "+printCustomer.getAccountNumber()+" " +
                    ""+printCustomer.getBalance()+" "+printCustomer.getName()+" "+printCustomer.getEncryptedPassword());
        }
    }
}
