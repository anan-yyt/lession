package lession1;

import java.util.ArrayList;

public class Count {
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,8};
        ArrayList evenArr = new ArrayList();
        ArrayList obbArr = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                evenArr.add(arr[i]);
            } else {
                obbArr.add(arr[i]);

            }
        }
        System.out.println("Even list : " + evenArr);
        System.out.println("Count even in list : " + evenArr.size());
        System.out.println("Obb list : " + obbArr);
        System.out.println("Count obb in list : " + obbArr.size());
    }

}