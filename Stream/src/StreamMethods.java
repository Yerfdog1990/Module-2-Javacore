import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethods {
    public static void main(String[] args) {
        // 1. of() - Create a stream from a set of objects
        Stream <String > streamOf = Stream.of("Hello", "from", "Java", "Programming");

        // 2. generate() - Generate an infinite stream based on a rule (limit to 5 elements)
        Stream<Double> streamGenerateDouble = Stream.generate(Math::random).limit(5);
        Stream<Integer> streamGenerateInt = Stream.generate(Math::random).limit(5).map(d -> (int)(d*100));

        // 3. concat() - Concatenate two streams
        Stream<String> streamConcate = Stream.concat(Stream.of("Owino", "Otieno", "Okoth"), Stream.of("Akinyi", "Atieno", "Apiyo"));

        // 4. filter() - Filter elements based on a condition
        Stream<String> streamFilter = streamOf.filter(s -> s.contains("O"));

        // 5. distinct() - Remove duplicates
        Stream<String> stringStream1 = Stream.of("One", "Two", "Three", "Four");
        Stream<String> streamDistinct = stringStream1.distinct();

        // 6. sorted() - Sort the elements
        Stream<String> stringStream2 = Stream.of("One", "Two", "Three", "Four");
        Stream<String> streamSorted = stringStream2.sorted();


        // 7. peek() - Perform an action on each element (here we print)
        Stream<String> stringStream3 = Stream.of("One", "Two", "Three", "Four");
        Stream<String>  streamPeeked = stringStream3.peek(System.out::println);

        // 8. limit() - Limit the stream to a certain number of elements
        Stream<String> stringStream4 = Stream.of("One", "Two", "Three", "Four");
        Stream<String> streamLimit = stringStream4.limit(2);

        // 9. skip() - Skip the first n elements
        Stream<String> stringStream5 = Stream.of("One", "Two", "Three", "Four");
        Stream<String> streamSkip = stringStream5.skip(1);

        // 10. map() - Convert elements (here, convert to uppercase)
        Stream<String> stringStream6 = Stream.of("One", "Two", "Three", "Four");
        Stream<String> streamUpperCase = stringStream6.map(String::toUpperCase);

        // 11. flatMap() - Flatten nested structures (here, split strings by letter)
        Stream<String> stringStream7 = Stream.of("One", "Two", "Three", "Four");
        Stream<String> streamFlatMapped = stringStream7.flatMap(str -> Arrays.stream(str.split("")));

        // 12. anyMatch() - Check if any element matches a condition
        Stream<String> stringStream8 = Stream.of("One", "Two", "Three", "Four");
        boolean anyMatch = stringStream8.anyMatch(s -> s.startsWith("a"));

        // 13. allMatch() - Check if all elements match a condition
        Stream<String> stringStream9 = Stream.of("One", "Two", "Three", "Four");
        boolean allMatch = stringStream9.allMatch(str -> str.length() > 3);

        // 14. noneMatch() - Check if no elements match a condition
        Stream<String> stringStream10 = Stream.of("One", "Two", "Three", "Four");
        boolean noneMatch = stringStream10.noneMatch(str -> str.contains("z"));

        // 15. findFirst() - Get the first element
        Stream<String> stringStream11 = Stream.of("One", "Two", "Three", "Four");
        Optional<String> findFirst = stringStream11.findFirst();

        // 16. findAny() - Get any element
        Stream<String> stringStream12 = Stream.of("One", "Two", "Three", "Four");
        Optional<String> findAny = stringStream12.findAny();

        // 17. min() - Find the minimum element (lexicographically)
        Stream<String> stringStream13 = Stream.of("One", "Two", "Three", "Four");
        Optional<String> minElement = stringStream13.min(Comparator.naturalOrder());

        // 18. max() - Find the maximum element (lexicographically)
        Stream<String> stringStream14 = Stream.of("One", "Two", "Three", "Four");
        Optional<String> maxElement = stringStream14.max(Comparator.naturalOrder());

        // 19. count() - Count the number of elements
        Stream<String> stringStream15 = Stream.of("One", "Two", "Three", "Four");
        long count = stringStream15.count();

        // 20. collect() - Collect the stream elements into a List
        Stream<String> stringStream16 = Stream.of("One", "Two", "Three", "Four");
        List<String> stringList = stringStream16.collect(Collectors.toList());
        // Displaying some of the results
        System.out.println("Generated stream: " + streamGenerateDouble.collect(Collectors.toList()));
        System.out.println("Generated stream: " + streamGenerateInt.collect(Collectors.toList()));
        System.out.println("Concatenated stream: " + streamConcate.collect(Collectors.toList()));
        System.out.println("Filtered stream: " + streamFilter.collect(Collectors.toList()));
        System.out.println("Distinct stream: " + streamDistinct.collect(Collectors.toList()));
        System.out.println("Mapped to uppercase: " + streamUpperCase.collect(Collectors.toList()));
        System.out.println("FlatMapped stream: " + streamFlatMapped.collect(Collectors.toList()));
        System.out.println("Any element starts with 'a': " + anyMatch);
        System.out.println("All elements length > 3: " + allMatch);
        System.out.println("None contains 'z': " + noneMatch);
        System.out.println("First element: " + findFirst.orElse("none"));
        System.out.println("Any element: " + findAny.orElse("none"));
        System.out.println("Min element: " + minElement.orElse("none"));
        System.out.println("Max element: " + maxElement.orElse("none"));
        System.out.println("Element count: " + count);
    }
}
