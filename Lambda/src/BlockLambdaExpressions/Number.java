package BlockLambdaExpressions;

public interface Number {
    boolean checkEven(int n);
}
class DriverClass{
    public static void main(String[] args) {
        // Lambda expression body
        Number isEven = (n)-> (n % 2) == 0;
        // Above is lambda expression which tests
        // passed number is even or odd
        if(isEven.checkEven(21))
            System.out.println("The number is even.");
        else
            System.out.println("The number is odd.");
    }
}
