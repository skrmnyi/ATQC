package JavaBasics;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        integerList.add(42); // Adding an Integer, which is allowed
        integerList.add(99); // Adding another Integer, which is allowed

        // Trying to add different types to List<Integer> (will raise an error)
        //integerList.add(3.14); // Compilation error: incompatible types
        //integerList.add("Hello"); // Compilation error: incompatible types

        List list = new ArrayList<>();
        list.add(42);
        list.add("hello");
        System.out.println(list);

    }


}

