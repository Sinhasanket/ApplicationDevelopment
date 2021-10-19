package Coding.services;

import Coding.model.Customer;

import java.util.HashMap;

public interface CustomerAccountService {
    void withdrawAmount(Customer customer) throws Exception;
    void depositAmount(Customer customer) throws Exception;
    void transferAmount(HashMap<Integer,Customer> allCustomers,Customer customer) throws Exception;
}