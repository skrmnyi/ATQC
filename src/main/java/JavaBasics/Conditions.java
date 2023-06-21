package JavaBasics;

public class Conditions {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        if (a > b) {
            System.out.println(a + " is bigger than " + b);
        }
        else {
            System.out.println(b + " is bigger than " + a);
        }

        System.out.println(a>b ? b + " is bigger than " + a: b + " is bigger than " + a);

    }
}

