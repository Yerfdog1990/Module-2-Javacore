package CreateLambdaExpression;
public interface Calculator {
    double calculate(double num1, double num2);
}
class CalculatorApp{
    public static void main(String[] args) {
        Calculator addition = (num1, num2) -> num1 + num2;
        Calculator subtraction = (num1, num2) -> num1 - num2;
        Calculator division = (num1, num2) -> num1 / num2;
        Calculator multiply = (num1, num2) -> num1 * num2;

        try {
            System.out.println("Addition: " +addition.calculate(2.3, 5.6));
            System.out.println("Subtraction: " +subtraction.calculate(2.3, 5.6));
            System.out.println("ADivision: " +division.calculate(2.4, 1.2));
            System.out.println("Multiplication: " +multiply.calculate(2.3, 5.6));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}