package JavaBasics;

class Comparing {
    public static void main(String args[]) {
        boolean a = true;
        boolean b = false;
        boolean c = a || b;
        boolean d = a && b;
        boolean e = a ^ b;
        boolean f = (!a & b) | (a & !b);
        boolean g = !a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a || b = " + c);
        System.out.println("a && b = " + d);
        System.out.println("a ^ b = " + e);
        System.out.println("!a & b | a & !b = " + f);
        System.out.println("!a = " + g);

        boolean x = (a || b) && (!a || !b);
        boolean q = (!a || b) && (!a || !b);
        System.out.println(x);
        System.out.println(q);
        System.out.println("_________");

        int ab = 2;
        int ba = 5;

        double ca = 5.5;

        if (ab > 1) {
            System.out.println("simple > operator");
        }
        if (ba < 6) {
            System.out.println("simple < operator");
        }
        if (ba <= 5) {
            System.out.println("<= means less or equals");
        }
        if (ab >= 1) {
            System.out.println(">= means bigger or equals");
        }
        if (ab == 1) {
            System.out.println("== means equal");
        }
        if (ab !=5) {
            System.out.println("!= means not equal");
        }

    }
}

