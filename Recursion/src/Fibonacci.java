public class Fibonacci {
    public static void main(String[] args) {
        System.out.print("\nFibonacci series using recursion method: ");
        int number = 10;
        for (int i = 0; i < number; i++) {
            System.out.print(applyRecursion(i) + ", ");
        }
        applyIteration(10);
    }
    // Recursive method to calculate Fibonacci number
    private static int applyRecursion(int n){
        if(n == 0 || n == 1){ //Base case
            return n;
        }else{
            return applyRecursion(n - 1) + applyRecursion(n - 2); // Recursive calls
        }
    }
    private static void applyIteration(int n){
        int firstNumber = 0, secondNumber = 1; //Initialize first two numbers
        System.out.print("\nFibonacci series using iteration method: "+firstNumber+ ", " +secondNumber);
        for (int i = 2; i < n; i++) {
            int nextNumber = firstNumber + secondNumber; //Define the next number
            System.out.print(", " +nextNumber);
            firstNumber = secondNumber;
            secondNumber = nextNumber; // Update next number
        }
    }
}
