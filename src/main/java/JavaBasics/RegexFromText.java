package JavaBasics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegexFromText {
    public static void main(String[] args) {
        String filePath = "src/main/resources/text.txt"; // path to file

        // Read the file and extract IP addresses using regex
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String ipAddress = matcher.group();
                    System.out.println("Found IP address: " + ipAddress);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

