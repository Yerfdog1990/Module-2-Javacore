package CreateStream;

import java.util.stream.Stream;

public class Method4 {
    public static void main(String[] args) {
        Stream<String> streamBuilder = Stream.<String>builder()
                .add("Kenya")
                .add("Uganda")
                .add("Tanzania")
                .add("Rwanda")
                .add("Burundi").build();
        streamBuilder.forEach(System.out::println);
    }
}
