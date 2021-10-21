package Coding.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputTaker {
    public static String[] take() throws Exception{
        String[] newUserDetails = new String[2];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Enter your name : ");
        String customerName = reader.readLine();
        System.out.println("Please Enter Password : ");
        String password = reader.readLine();
        System.out.println("Re-Enter the Password : ");
        String reEnteredPassword = reader.readLine();

        while (password.equals(reEnteredPassword)==false){
            System.out.println("Your Password is not Matching. Please Re-Enter Password : ");
            reEnteredPassword = reader.readLine();
        }

        newUserDetails[0]  = customerName;
        newUserDetails[1] = password;

        return newUserDetails;
    }
}
