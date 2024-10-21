package SwitchExpression;

public class BirthMonth {

    // Enum for months
    public enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public static void main(String[] args) {
        // Example call for both methods using Month.MARCH
        System.out.println("Using switch statement:");
        useSwitchStatement(Month.MARCH);

        System.out.println("\nUsing switch expression:");
        useSwitchExpression(3);
    }

    // Method that uses the traditional switch statement
    static void useSwitchStatement(Month month) {
        Month birthMonth = null;

        switch (month) {
            case JANUARY:
                birthMonth = Month.JANUARY;
                break;
            case FEBRUARY:
                birthMonth = Month.FEBRUARY;
                break;
            case MARCH:
                birthMonth = Month.MARCH;
                break;
            case APRIL:
                birthMonth = Month.APRIL;
                break;
            case MAY:
                birthMonth = Month.MAY;
                break;
            case JUNE:
                birthMonth = Month.JUNE;
                break;
            case JULY:
                birthMonth = Month.JULY;
                break;
            case AUGUST:
                birthMonth = Month.AUGUST;
                break;
            case SEPTEMBER:
                birthMonth = Month.SEPTEMBER;
                break;
            case OCTOBER:
                birthMonth = Month.OCTOBER;
                break;
            case NOVEMBER:
                birthMonth = Month.NOVEMBER;
                break;
            case DECEMBER:
                birthMonth = Month.DECEMBER;
                break;
            default:
                System.out.println("Invalid month");
        }

        System.out.println("I was born in the month of " + birthMonth);
    }

    // Method that uses the switch expression (Java 12+)
    static void useSwitchExpression(int monthNumber) {
        // Switch expression returning the birth month based on the input number
        String birthMonth = switch (monthNumber) {
            case 1 -> "JANUARY";
            case 2 -> "FEBRUARY";
            case 3 -> "MARCH";
            case 4 -> "APRIL";
            case 5 -> "MAY";
            case 6 -> "JUNE";
            case 7 -> "JULY";
            case 8 -> "AUGUST";
            case 9 -> "SEPTEMBER";
            case 10 -> "OCTOBER";
            case 11 -> "NOVEMBER";
            case 12 -> "DECEMBER";
            default -> "Invalid month";
        };

        System.out.println("I was born in the month of " + birthMonth);
    }
}
