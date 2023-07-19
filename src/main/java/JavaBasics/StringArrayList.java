package JavaBasics;

import java.util.ArrayList;
import java.util.List;

public class StringArrayList {
    public static void main(String[] args) {

        List<String> myString = new ArrayList<String>();
        myString.add("abra");
        myString.add("cadabra");
        myString.add("shvabra");

        System.out.println(myString.get(1));
        System.out.println(myString.size());
        for (String elem : myString) {
            if (elem.contains("abra")) {
                System.out.println("your array contains some abra cadabra");
                break;
            }
        }

        System.out.println(myString.isEmpty());

        myString.remove(myString);

        myString.remove(1);
        System.out.println(myString);

    }
}
