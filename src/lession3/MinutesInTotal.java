package lession3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MinutesInTotal {
    public static void main(String[] args) {
        String totalString = "3hrs and 21 minutes";
        int minHour = 0;
        int total;
        String[] words = totalString.split("\\s");
        List<String> listString = new ArrayList<>();
        // find hour and covert to minute
        for (String w : words) {
            listString.add(w);
        }
        System.out.println("List String after split: " + listString);
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(listString.get(0));
        if (matcher.find()) {
            String hour = matcher.group();
            minHour = Integer.parseInt(hour)*60;
        }
        else {
            System.out.println("Don't have hour");
        }
        //Total number
        total = minHour + Integer.parseInt(listString.get(2));
        System.out.println(totalString + " : " + total + " minutes");

    }

}
