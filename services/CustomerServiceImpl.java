package Coding.services;

import Coding.model.Customer;
import Coding.util.PasswordEncypter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;

public class CustomerServiceImpl implements CustomerService{
    private static int latestCustomerId = -1;
    private static int latestAccountNumber = -1;
    @Override
    public void addCustomer(HashMap<Integer,Customer> allCustomers, String[] newUser) throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\91758\\IdeaProjects\\Java\\src\\Coding\\bank_db.txt",true));
        StringBuilder newUserDetails = new StringBuilder();

        Customer newCustomer = new Customer(latestCustomerId,latestAccountNumber);
        PasswordEncypter encrypter = new PasswordEncypter();
        String encryptedPassword = encrypter.encrypt(newUser[1]);

        newUserDetails.append(newCustomer.getCustId()  ).append(" ");
        newUserDetails.append(newCustomer.getAccountNumber()).append(" ");
        newUserDetails.append(newUser[0]).append(" ");
        newUserDetails.append(newCustomer.getBalance()).append(" ");
        newUserDetails.append(encryptedPassword).append("\n");

        latestCustomerId = newCustomer.getCustId();
        latestAccountNumber = newCustomer.getAccountNumber();

        writer.write(newUserDetails.toString());
        writer.flush();
        writer.close();
    }

    @Override
    public Customer authenticateUser(HashMap<Integer, Customer> allCustomers, int customerId, String password) {
        if (allCustomers.containsKey(customerId)){
            PasswordEncypter encrypter = new PasswordEncypter();
            String encrypt = encrypter.encrypt(password);
            Customer databaseUser = allCustomers.get(customerId);
            String storedPassword = databaseUser.getEncryptedPassword();

            if (encrypt.equals(storedPassword)){
                return databaseUser;
            }
            return null;
        }
        return null;
    }
}