package lession2;

public class FindingIndices {
    public static void main(String[] args) {
        int [] myIntArr = {1,2,3,4,5,6};
        int inputNum = 7;
        for (int i = 0; i < myIntArr.length ; i++) {
            for (int j = i+1; j < myIntArr.length; j++) {
                if (myIntArr[i] + myIntArr[j] == inputNum ) {
                    System.out.println("(" + i + ", " + j + ")");
                }
            }
        }
    }
}
