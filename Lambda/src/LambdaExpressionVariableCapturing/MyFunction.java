package LambdaExpressionVariableCapturing;

public interface MyFunction {
    int func(int n);
}
class Driver{
    public static void main(String[] args) {
        // Custom local variable that can be captured
        int number = 10;
        MyFunction myFunction = (n) ->{
            int value = number + n;
            return value;
        };
        System.out.println(myFunction.func(10));
    }
}