package Coding.services;

import Coding.model.Customer;

import java.util.HashMap;

public interface CustomerService {
    void addCustomer(HashMap<Integer,Customer> allCustomer, String[] newUser) throws Exception;
    Customer authenticateUser(HashMap<Integer,Customer> allCustomers,int customerId, String password);
    void showTopNCustomer(int n, HashMap<Integer,Customer> allCustomers);
}