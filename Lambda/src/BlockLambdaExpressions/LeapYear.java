package BlockLambdaExpressions;

public interface LeapYear {
    boolean function(int n);
}
class MainClass{
    public static void main(String[] args) {
        LeapYear isALeapYear = (n) ->{
            if((n%4 == 0) ||(n%400 == 0) && (n%100 != 0))
                return true;
            else
                return false;
        };
        System.out.println(isALeapYear.function(2007));
    }
}
