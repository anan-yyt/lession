package lession1;

public class Maxnumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 13, 3, 4, 13, 5, 6, 7, 8, 9, 29};
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i] ){
                max = arr[i];
            }
        }
        System.out.println("Max number : " + max);

    }
}