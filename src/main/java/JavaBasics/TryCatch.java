package JavaBasics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryCatch {


    // throws в сигнатурі метода як спосіб не обробляти виключення через try catch
    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File("messages.txt");
//        Scanner scan = new Scanner(file);



        //try catch оброблення виключення. блоків catch може бути безліч
        // блок finally відбувається завжди, навіть коли виключення не відбулося
        File file1 = new File("messages.txt");
        try {
            Scanner scan1 = new Scanner(file1);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("The end");
        }
    }
}
