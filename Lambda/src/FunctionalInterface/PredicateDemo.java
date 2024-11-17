package FunctionalInterface;

import java.util.function.Predicate;

public class PredicateDemo {
    public static int n = 102;
    public static boolean checkEven(int n){
        if(n % 2 == 0){
            return true;
        }else{
            return false;
        }
    }
    //Main class
    public static void main(String[] args) {
        //Using anonymous class
        Predicate<Integer> isEven1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return checkEven(n);
            }
        };
        System.out.println("Using anonymous class: " +n+ " is even: " +isEven1.test(n));

        //Using lambda expression
        Predicate<Integer> isEven2 = (n) -> {
            return checkEven(n);
        };
        System.out.println("Using lambda expression. " +n+ " is even: " +isEven2.test(n));

        //Using method referencing
        Predicate<Integer> isEven3 = PredicateDemo:: checkEven;
        System.out.println("Using method referencing. " +n+ " is even: " +isEven3.test(n));
    }
}
