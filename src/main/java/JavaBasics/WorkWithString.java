package JavaBasics;

import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.Arrays;
import java.util.List;

public class WorkWithString {
    public static void main(String[] args) {
        String a = "start text ";
        String b = "end text";
        System.out.println(a + b);
        System.out.println(a + b + 1);

        String task = " eqw eerw ererferw kuy yu i .";
        String doTask = task.trim();


        List<String> doTask3 = Arrays.asList(doTask.trim().split("\\s+"));
        for (int i = 0; i < doTask3.size(); i++) {
        }
        System.out.println(doTask3);

        String lastTask = "this item previous price $5.99, Sale price $1.99. ";
        String origPrice = lastTask.substring(25, 30);
        String salePrice = lastTask.substring(43, 49);
        System.out.print(origPrice + " / " + salePrice);


    }


}
