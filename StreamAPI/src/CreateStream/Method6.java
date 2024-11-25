package CreateStream;

import java.util.Random;
import java.util.stream.Stream;

public class Method6 {
    public static void main(String[] args) {
        Stream<Integer> generate = Stream.generate(new Random()::nextInt).limit(10);
        generate.forEach(System.out::println);
    }
}
