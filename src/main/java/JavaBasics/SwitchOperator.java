package JavaBasics;

public class SwitchOperator {
    static void monthDaysCounter(int monthNumber) {
        switch (monthNumber) {
            case 1:
            case 3:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(monthNumber + " month of the 2023 Year contains 31 days");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(monthNumber + " month of the 2023 Year contains 30 days");
                break;
            case 2:
                System.out.println(monthNumber + " month of the 2023 Year contains 28 days");
                break;
            default:
                System.out.println("Sorry, you are not right, we have only 12 months in a year");
        }
    }

    public static void main(String[] args) {
        monthDaysCounter(12);
    }
}

