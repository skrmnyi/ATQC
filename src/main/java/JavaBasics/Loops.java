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




    }







}
