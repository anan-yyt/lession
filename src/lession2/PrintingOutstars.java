package lession2;

import java.util.Scanner;

public class PrintingOutstars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your number: ");
        int number = Integer.parseInt(input.nextLine());
        for (int i = number -1 ; i >= 0; i--) {
            for (int j = 0; j <= i;j++) {
                System.out.print("*");
            }
            System.out.println();

        }
}}

