package lession1;

public class Factorial {
    public static void main(String[] args) {
        int num = 0;
        int fac = 1;
        if (num==0 ) {
            System.out.println("Factorial of 0!: 1");
        }
        if(num > 0) {
            for (int i = 1; i <= num; i++) {
                fac = fac * i;
            }
            System.out.println("Factorial of " + num + " : " + fac);
        }
       if(num < 0) {
           System.out.println("The factorial of a non-negative integer");
       }

    }
}
