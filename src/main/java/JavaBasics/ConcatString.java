package JavaBasics;


import java.util.Arrays;

public class ConcatString {
    public static void main(String[] args) {
        String one = "The beginning ";
        String two = "The end";
        System.out.println(one + two); //concatenation = обєднання
        System.out.println(one + two + " the end is a new beginning"); //concatenation = обєднання
        System.out.println(one.concat(two));
        System.out.println(one + 1);

        int num = 121;
        String str = Integer.toString(num);
        System.out.println(str + num);

        String hw = "egweerw ereferw kuy yu i ";
        System.out.println(hw.length());
        System.out.println(hw.trim()); // remove spaces
        System.out.println(hw.trim().length()); // count without spaces

        String[] splitStr = hw.trim().split("\\s+");
        System.out.println(Arrays.toString(splitStr));
        Arrays.stream(splitStr).forEach(System.out::println); // stream for print each element;



        String hw2 = "egweerw ereferw kuy yu i ";
        System.out.println(hw2.toUpperCase(char e))

    }


}
