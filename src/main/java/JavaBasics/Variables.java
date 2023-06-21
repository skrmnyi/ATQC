package JavaBasics;

public class Variables {
    public static void main(String[] args) {

        long longVariable = 1111l;
        int intVariable = 1;
        short shortVariable = 2;
        byte byteVariable = 64;
        double doubleVariable = 4.4;
        float floatVariable = 4.4f;
        char charVariabe = 'A';

        boolean logic = true;

        String message = "This message created for testing purpose";

        int firstNumbers[] = {1, 2, 3, 4};

        int lastNumbers[] = {100, 99, 98, 97};

        String arrayWords[] = {"Hello", "World"};
        
        int varWithoutValue = 0; 

        System.out.println(longVariable);
        System.out.println(arrayWords.toString());
        System.out.println(varWithoutValue);


        double check = 0.5;
        float check2 = 0.5f;
        if (check == check2) {
            System.out.println("the values are the same");
        }


        ///int checkDevide = 2/0;
        ///int checkDevide2 = 0/2;

        int reasignToLong = 123;
        long reasignToInt = 1234444L;
        /// reasignToLong =  reasignToInt; error diffrent types








    }



}






