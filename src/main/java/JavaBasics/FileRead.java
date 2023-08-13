package JavaBasics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class FileRead {
    public static void main(String[] args) {


        Logger logger = LogManager.getLogger(FileRead.class);

        // File path
        String filePath = "src/main/resources/new_example.txt";

        // Writing content to the file
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            String content = "Hello, this is some text inside the file.";
            fileWriter.write(content);
            System.out.println("File content written successfully.");
        } catch (IOException e) {
            e.printStackTrace();

        }

        // Reading and displaying content using FileReader (Character Stream)
        try (FileReader fileReader = new FileReader(filePath)) {
            int character;
            System.out.println("File content using FileReader:");
            logger.info("Info message.");
            while ((character = fileReader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println();  // New line after reading
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Updating the file content
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            String updateContent = "\nThis is the updated content.";
            fileWriter.write(updateContent);
            System.out.println("File content updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading and displaying content using FileInputStream (Byte Stream)
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            int byteRead;
            System.out.println("File content using FileInputStream:");
            while ((byteRead = fileInputStream.read()) != -1) {
                System.out.print((char) byteRead);
                logger.debug("Debug message.");
            }
            System.out.println();  // New line after reading
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.error("An error occurred.");
    }
}
