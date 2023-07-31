package JavaBasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    public void readPropertyFile(String src) {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(src)) {
            properties.load(input);
            properties.forEach((key, value) -> System.out.println(key + "=" + value));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PropertiesReader propertiesReader = new PropertiesReader();
        String filePath = "src/main/resources/file.properties";
        propertiesReader.readPropertyFile(filePath);
    }
}
