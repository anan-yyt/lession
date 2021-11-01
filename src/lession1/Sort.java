package lession1;

import java.util.ArrayList;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {9,11,1,3,4};
        ArrayList sortArr = new ArrayList();
        int number = arr[0];
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i +1 ; j < arr.length ; j++) {
                if (arr[i] > arr[j]) {
                number = arr[j];
                arr[j] = arr[i];
                arr[i] = number;
                System.out.println( number);
                sortArr.add(number);
            }

            }

        }
        System.out.println(sortArr);
    }
}
