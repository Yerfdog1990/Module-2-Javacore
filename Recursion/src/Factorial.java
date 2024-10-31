public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        int result = calculateFactorial(n);
        System.out.printf("Factorial of %d is %d. ", n, result);
    }
    static int calculateFactorial(int n){
        if(n == 0){
            return 1;
        }else{
            return n*calculateFactorial(n-1);
        }
    }
}
