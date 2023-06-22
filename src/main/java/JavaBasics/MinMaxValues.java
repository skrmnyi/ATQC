package JavaBasics;

public class MinMaxValues {
    int min;
     public void minValue (int a, int b) {
         if (a < b) {
             int min = a;
             System.out.println("Min value is " +min);
         } else if (a > b) {
             int min = b;
             System.out.println("Min value is " +min);
         } else if (a == b) {
             System.out.println("The values are the same");
         }
     }


    public void maxValue(int c, int d) {
        int max = (c > d || c!=d && d < c) ? (c) : (d);
        System.out.println(max);
    }

//    public void powValue (int val, int exp) {
//        (val == exp) ? (System.out.println("the values are the same")) : (System.out.println("values are not the same"));
//    }

    public void xorExample() {
        System.out.println("XOR EXAMPLE:");
        System.out.println("false XOR false = " + (false ^ false));
        System.out.println("false XOR true  = " + (false ^ true));
        System.out.println("true  XOR false = " + (true ^ false));
        System.out.println("true  XOR true  = " + (true ^ true));
        System.out.println();
    }

    public void checkEqual (double val1, double val2) {
         if ( val1==val2) {
             System.out.println(" the values are the same");
         }
         else {
             System.out.println("the values are not the same");
         }

         //how to write the same way in ternary operator
    }

    public void moduleFrom (int value, int module) {
        System.out.println(value % module);
    }


    public static void main(String[] args) {
        MinMaxValues test = new MinMaxValues();
        test.minValue(2, 5);
        test.maxValue(22,222);
        test.xorExample();
        test.checkEqual(2.0, 2.3);
        test.moduleFrom(10, 3);
    }
}
