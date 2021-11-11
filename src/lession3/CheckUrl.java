package lession3;

import java.util.ArrayList;
import java.util.List;

public class CheckUrl {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String url = "https://google.com";
        String[] arrOfStr = url.split("\\W");
        for (String a : arrOfStr) {
            if (!a.isEmpty()) {
                list.add(a);
            }
        }
        System.out.println(list);
        for (int i = 0;i < list.size() ; i++) {
            System.out.println(list.get(i));
            String first = list.get(0);
            String last = list.get(list.size()-1);
            if (first.equals("http") || first.equals("https")) {
                System.out.println("First index : " +first);
        }
            if (last.equals("net") || last.equals("com")) {
                System.out.println("Last index : ." + last);

        }
    }

}

}



