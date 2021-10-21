package Coding.util;

public class PasswordEncrypter {
    public static String encrypt(String password){
        StringBuilder encryptedPassword = new StringBuilder();
        for (char curr : password.toCharArray()){
            if (curr >= 'a' && curr <= 'z'){
                if (curr == 'z'){
                    curr = 'a';
                    encryptedPassword.append(curr+"");
                }else {
                   int increaseCurrent = curr;
                   increaseCurrent++;
                   char newChar = (char) (increaseCurrent);
                   encryptedPassword.append(newChar+"");
                }
            }else if (curr >= 'A' && curr <= 'Z'){
                if (curr == 'Z'){
                    curr = 'A';
                    encryptedPassword.append(curr+"");
                }else {
                    int increaseCurrent = curr;
                    increaseCurrent++;
                    char newChar = (char) (increaseCurrent);
                    encryptedPassword.append(newChar+"");
                }
            }else {
                if (curr == '9'){
                    curr = '0';
                    encryptedPassword.append(curr+"");
                }else {
                    int newNum = curr;
                    newNum++;
                    char newNumChar = (char) newNum;
                    encryptedPassword.append(newNumChar+"");
                }
            }
        }
        return encryptedPassword.toString();
    }
}