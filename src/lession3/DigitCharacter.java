package lession3;

import java.util.ArrayList;
import java.util.List;

public class DigitCharacter {
    public static void main(String[] args) {
        List<Integer> listNumber = new ArrayList<>();
        int intValue;
        String myStr = "12345nabc678";
        String[] text = myStr.split("");
        for (int i = 0; i < text.length ; i++){
            try {
                intValue = Integer.parseInt(text[i]);
                listNumber.add(intValue);
            } catch (NumberFormatException e) {
            }
         }
        for (int i = 0; i < listNumber.size() ; i++) {
            System.out.print( listNumber.get(i) + "");
        }
    }
}
