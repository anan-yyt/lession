package lession3;

import java.util.Scanner;

public class MaximumInput {
    public static void main(String[] args) {
        String myPassword = "password123";
        int attempts = 2;
        String enterPassword;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your password: ");
        enterPassword = scan.nextLine();
        if (enterPassword.equals(myPassword)){
            System.out.println("Your password is right");
        }
        else {
            for (int i = 0; i < attempts ; i++) {
                System.out.println("Please input your password: ");
                enterPassword = scan.nextLine();
                if (enterPassword.equals(myPassword)) {
                    System.out.println("Your password is right");
                    break;

                }
            }
        }


    }

}
