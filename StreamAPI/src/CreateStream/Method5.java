package CreateStream;

import java.util.stream.Stream;

public class Method5 {
    public static void main(String[] args) {
        Stream<Integer> iterate = Stream.iterate(1, n -> n + 2).limit(10);
        iterate.forEach(System.out::println);
    }
}
