package CreateStreams;

import java.util.stream.Stream;

public class EmptyStream {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.empty();
        stringStream.forEach(System.out::println);
    }
}
