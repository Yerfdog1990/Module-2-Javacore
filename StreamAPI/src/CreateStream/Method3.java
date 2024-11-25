package CreateStream;

import java.util.stream.Stream;

//Creating a Stream using `Stream.of`
public class Method3 {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("Kenya", "Uganda", "Tanzania", "Rwanda", "Burundi");
        stringStream.forEach(System.out::println);
    }
}
