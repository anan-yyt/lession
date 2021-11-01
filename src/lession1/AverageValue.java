package lession1;

import java.util.Arrays;

public class AverageValue {
    public static void main(String[] args) {
        double[] arr = {1,2,3,4,5,6,7,8,11,31,6};
        double sumArr= 0;
        double average;
        for (double number : arr) {
            sumArr = sumArr + number ;
        }
        average = sumArr/arr.length;
        System.out.println("Sum arr : " + sumArr );
        System.out.println("Length : " + arr.length);
        System.out.println("Average Value : " + average);
    }
}
