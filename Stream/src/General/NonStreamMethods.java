package General;

import java.util.stream.Stream;
/*
The Stream class has three standard methods that do not construct streams, but instead check what kind of data is in them.
These methods are: anyMatch(), allMatch(), and noneMatch().
boolean anyMatch(rule) method
This method checks whether the stream has at least one element that satisfies the rule that is passed to the method.
If there is such an element, the method returns true, otherwise false.
 */
public class NonStreamMethods {
    public static void main(String[] args) {
        String answerYes = "Yes";
        String answerNo = "No";

        Stream<Integer> stream1 = Stream.of(10, -22, 3, 12, -85, 0, 142);

        String answerNegativeEvenNumbers = hasNegativeEvenNumbers(stream1) ? answerYes : answerNo;
        System.out.println("Any negative even numbers in the stream? " + answerNegativeEvenNumbers);

        Stream<Integer> stream2 = Stream.of(10, 22, 3, 12, 85, 142);

        String answerOnlyPositiveNumbers = hasOnlyPositiveNumbers(stream2) ? answerYes : answerNo;
        System.out.println("Only positive numbers in the stream? " + answerOnlyPositiveNumbers);

        Stream<Integer> stream3 = Stream.of(-10, -22, -3, -12, -85, -142);

        String answerOnlyNegativeNumbers = hasOnlyNegativeNumbers(stream3) ? answerYes : answerNo;
        System.out.println("Only negative numbers in the stream? " + answerOnlyNegativeNumbers);
    }

    public static boolean hasNegativeEvenNumbers(Stream<Integer> stream) {
        return stream.anyMatch(i -> i < 0 && i % 2 == 0);
    }

    public static boolean hasOnlyPositiveNumbers(Stream<Integer> stream) {

        return stream.allMatch(i -> i > 0);
    }

    public static boolean hasOnlyNegativeNumbers(Stream<Integer> stream) {

        return stream.noneMatch(i -> i > 0);
    }
}
