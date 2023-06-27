package JavaBasics;

import java.util.ArrayList;
import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {

        int i = 0;
        while (i <= 10) {
            System.out.println("i value is " + i);
            i++;
        } //while condition is true - cycle would be executed

        
        String s;
        Scanner console = new Scanner(System.in);
        do {
            s = console.nextLine();
        }
        while (!s.equals("exit"));
        // at least 1 time cycle would be executed

        for (int j = 0; j <= 10; j++) {
            System.out.println("for cycle would be displayed - " + j + "times");

        }

        ArrayList<String> list = new ArrayList<>();
        list.add("some element_1");
        list.add("some element_2");
        list.add("some element_3");
        list.add("some element_4");
        list.add("some element_5");
        list.add("some element_6");
        list.add("some element_7");
        list.add("some element_8");
        list.add("some element_9");
        list.add("some element_10");
        for (String str: list) {
            System.out.println(str);
        }

    }







}
