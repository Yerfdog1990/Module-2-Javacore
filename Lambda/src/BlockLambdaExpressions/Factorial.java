package BlockLambdaExpressions;

public interface Factorial {
    int fun(int n);
}
class Main{
    public static void main(String[] args) {
        Factorial findFactorial = (n)->{
            int result = 1;
            // iterating from 1 to the current number
            // to find factorial by multiplication
            for (int i = 1; i < n+1; i++) {
                result = i * result;
            }
            return result;
        };
        System.out.println("5! = " +findFactorial.fun(5));
    }
}
