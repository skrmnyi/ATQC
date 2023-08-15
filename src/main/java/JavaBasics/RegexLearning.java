package JavaBasics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegexLearning {

    public static void main(String[] args) {
        String text = "There are 123 apples and 456 oranges in the basket.";
        String textIp = "The server's IP address is 192.168.1.1 and the client's IP address is 10.0.0.2.";

        // Define the regex pattern to match digits
        String regexDigits = "\\d+";
        String regexLetters = "[a-zA-Z]+";
        String regexIp = "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b";

        // Create a Pattern object
        Pattern pattern0 = Pattern.compile(regexDigits);
        Pattern pattern1 = Pattern.compile(regexLetters);


        // Create a Matcher object and apply the pattern to the input text
        Matcher matcher = pattern0.matcher(text);
        Matcher matcher1 = pattern1.matcher(text);


        // Find and print all matches
        while (matcher.find()) {
            String digit = matcher.group();
            System.out.println("Found digit: " + digit);
        }

        while (matcher1.find()) {
            String letters = matcher1.group();
            System.out.println("Found letters: " + letters);
        }
        // Filter and extract letters using Stream API
        String ips = Stream.of(textIp.split("\\s+"))  // Split the text by spaces
                .filter(word -> word.matches(regexIp))  // Filter words with letters
                .collect(Collectors.joining(" "));  // Join filtered words back into a string
        System.out.println("Extracted ip's: " + ips);
    }
}

