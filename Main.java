package Coding;

import Coding.model.Customer;
import Coding.services.CustomerAccountService;
import Coding.services.CustomerAccountServiceImpl;
import Coding.services.CustomerService;
import Coding.services.CustomerServiceImpl;
import Coding.util.InputTaker;
import Coding.util.Printer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private static CustomerService customerService;
    public static void main(String[] args) throws Exception{
        Initializer initializer = new Initializer();
        HashMap<Integer,Customer> allCustomers = initializer.initialize();

        String quit = "y";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (quit.equalsIgnoreCase("y")){
            System.out.println("Select Option \n (1) Add User \n (2) Authenticate User \n (3) User Account \n (4) Top N Customer");
            int option = Integer.parseInt(reader.readLine());
            switch (option){
                case 1:
                    addUser(allCustomers);
                    break;
                case 2:
                    Customer customer = authenticateUser(allCustomers,reader);
                    if (customer == null){
                        System.out.println("Invalid User");
                    }else {
                        System.out.println("User Authenticated");
                    }
                    break;
                case 3:
                    userAccount(allCustomers,reader);
                    break;
                case 4:
                    System.out.println("Enter a number to get top N Customer");
                    int n = Integer.parseInt(reader.readLine());
                    customerService = new CustomerServiceImpl();
                    customerService.showTopNCustomer(n,allCustomers);
                    break;
            }

            System.out.print("Want to Quit? (y/n)");
            quit = reader.readLine();
        }
        allCustomers = initializer.initialize();
        Printer printer = new Printer();
        printer.print(allCustomers);
    }

    public static void addUser(HashMap<Integer,Customer> allCustomers) throws Exception {
        System.out.println("/// ADD NEW USER ///");
        InputTaker inputTaker = new InputTaker();
        String[] newUser = inputTaker.take();
        customerService = new CustomerServiceImpl();
        customerService.addCustomer(allCustomers,newUser);
    }

    public static Customer authenticateUser(HashMap<Integer,Customer> allCustomers,BufferedReader reader) throws Exception{
        System.out.println("//// USER AUTHENTICATION //////");
        System.out.println("Please Enter customer Id : ");
        int customerId = Integer.parseInt(reader.readLine());
        System.out.println("Please ENTER Password");
        String password = reader.readLine();
        customerService = new CustomerServiceImpl();
        Customer isValidUser = customerService.authenticateUser(allCustomers,customerId,password);
        if (isValidUser != null){
            System.out.println("User Authenticated ");
            return  isValidUser;
        }else {
            System.out.println("Invalid Username Or Password");
            return null;
        }
    }

    public static void userAccount(HashMap<Integer,Customer> allCustomers,BufferedReader reader) throws Exception{
        System.out.println("///////// USER SERVICE //////////");
        System.out.println("Choose any one of the option \n (1) Withdraw. \n (2) Cash Deposit \n (3) Cash Transfer \n");
        int userChoice = Integer.parseInt(reader.readLine());
        Customer authenticateUser = authenticateUser(allCustomers,reader);
        if (authenticateUser!=null){
            CustomerAccountService customerAccountService = new CustomerAccountServiceImpl();
            switch (userChoice){
                case 1:
                    customerAccountService.withdrawAmount(authenticateUser);
                    break;
                case 2:
                    customerAccountService.depositAmount(authenticateUser);
                    break;
                case 3:
                    customerAccountService.transferAmount(allCustomers,authenticateUser);
                    break;
                default:
                    System.out.println("Enter Correct option");
                    break;
            }
        }
    }
}