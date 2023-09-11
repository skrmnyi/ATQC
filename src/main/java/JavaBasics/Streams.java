package JavaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Streams {
    public static void main(String[] args) {

        // Create a list of strings
        List<String> stringList = new ArrayList<>();
        // Add some values to the list
        stringList.add("bApple");
        stringList.add("banana");
        stringList.add("zherry");
        stringList.add("Date");
        stringList.add("Fig");
        stringList.add("1Fig");
        stringList.add("Aig");

        // Sort the list in natural order using a stream
        List<String> sortedList = stringList.stream()
                .sorted()
                .collect(Collectors.toList());
        // Print the sorted list
        System.out.println(sortedList);


        List<String> numbers = Arrays.asList("111", "543", "111", "124", "653", "1295", "6543", "543", "87654", "653");
        // Convert the list of strings to a list of integers using streams
        List<Integer> convertNumbers = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(convertNumbers);
        //print each values to console using forEach method
        convertNumbers.forEach(System.out::println);

        List<String> stringData = new ArrayList<>();
        stringData.add("Apple");
        stringData.add("Cherry");
        stringData.add("2Date");
        stringData.add("Date");
        stringData.add("Fig");
        stringData.add("12345");
        stringData.add("12");
        stringData.add("Fig");
        stringData.add("123");
        stringData.add("Banana");
        stringData.add("Grape");
        stringData.add("Grape");

        //make all operation in one stream
        List<String> newResult = stringData.stream()
                .sorted() // Sort in natural order as strings
                .filter(s -> s.length() > 3) // Delete values with more than 3 symbols
                .distinct() // Convert to a set to remove duplicates
                .collect(Collectors.toList());
        // Print each integer to the console
        newResult.forEach(System.out::println);

    }
}
