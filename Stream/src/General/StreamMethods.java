package General;

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
        System.out.println("\nGenerated stream: " + streamGenerateDouble.collect(Collectors.toList()));
        Stream<Integer> streamGenerateInt = Stream.generate(Math::random).limit(5).map(d -> (int)(d*100));
        System.out.println("\n2.Generated stream: " + streamGenerateInt.collect(Collectors.toList()));

        // 3. concat() - Concatenate two streams
        Stream<String> streamConcatenate = Stream.concat(Stream.of("Owino", "Otieno", "Okoth"), Stream.of("Akinyi", "Atieno", "Apiyo"));
        System.out.println("\n3.Concatenated stream: " + streamConcatenate.collect(Collectors.toList()));

        // 4. filter() - Filter elements based on a condition
        Stream<String> streamFilter = streamOf.filter(s -> s.contains("o"));
        System.out.println("\n4.Filtered stream: " + streamFilter.collect(Collectors.toList()));

        // 5. distinct() - Remove duplicates
        Stream<String> stringStream1 = Stream.of("One", "One", "Two", "Three", "Four");
        Stream<String> streamDistinct = stringStream1.distinct();
        System.out.println("\n5.Distinct stream: " + streamDistinct.collect(Collectors.toList()));

        // 6. sorted() - Sort the elements
        Stream<String> stringStream2 = Stream.of("Hello", "World!", "Welcome", "Java");
        List<String> streamSorted = stringStream2.sorted().collect(Collectors.toList());
        System.out.println("\n6.Sorted stream: " +streamSorted);

        // 7. peek() - Perform an action on each element (here we print)
        Stream<String> stringStream3 = Stream.of("One", "Two", "Three", "Four");
        Stream<String>  streamPeeked = stringStream3.peek(System.out::println);
        System.out.println("\n7.Peeked stream: " +streamPeeked.toList());

        // 8. limit() - Limit the stream to a certain number of elements
        Stream<String> stringStream4 = Stream.of("One", "Two", "Three", "Four");
        Stream<String> streamLimit = stringStream4.limit(2);
        System.out.println("\n8.Stream of 2 elements: " +streamLimit.collect(Collectors.toList()));

        // 9. skip() - Skip the first n elements
        Stream<String> stringStream5 = Stream.of("One", "Two", "Three", "Four");
        Stream<String> streamSkip = stringStream5.skip(1);
        System.out.println("\n9.Skip 1 element: " +streamSkip.collect(Collectors.toList()));

        // 10. map() - Convert elements (here, convert to uppercase)
        Stream<String> stringStream6 = Stream.of("One", "Two", "Three", "Four");
        Stream<String> streamUpperCase = stringStream6.map(String::toUpperCase);
        System.out.println("\n10.Mapped to uppercase: " + streamUpperCase.collect(Collectors.toList()));

        // 11. flatMap() - Flatten nested structures (here, split strings by letter)
        Stream<String> stringStream7 = Stream.of("One", "Two", "Three", "Four");
        Stream<String> streamFlatMapped = stringStream7.flatMap(str -> Arrays.stream(str.split("")));
        System.out.println("\n11.FlatMapped stream: " + streamFlatMapped.collect(Collectors.toList()));

        // 12. anyMatch() - Check if any element matches a condition
        Stream<String> stringStream8 = Stream.of("One", "Two", "Three", "Four");
        boolean anyMatch = stringStream8.anyMatch(str -> str.startsWith("a"));
        System.out.println("\n12.Any element starts with 'a': " + anyMatch);

        // 13. allMatch() - Check if all elements match a condition
        Stream<String> stringStream9 = Stream.of("One", "Two", "Three", "Four");
        boolean allMatch = stringStream9.allMatch(str -> str.length() > 3);
        System.out.println("\n13.All elements start with 'a': " + allMatch);

        // 14. noneMatch() - Check if no elements match a condition
        Stream<String> stringStream10 = Stream.of("One", "Two", "Three", "Four");
        boolean noneMatch = stringStream10.noneMatch(str -> str.contains("z"));
        System.out.println("\n14.No element starts with 'z': " +noneMatch);

        // 15. findFirst() - Get the first element
        Stream<String> stringStream11 = Stream.of("One", "Two", "Three", "Four");
        Optional<String> findFirst = stringStream11.findFirst();
        System.out.println("\n15.First element: " + findFirst.orElse("none"));

        // 16. findAny() - Get any element
        Stream<String> stringStream12 = Stream.of("One", "Two", "Three", "Four");
        Optional<String> findAny = stringStream12.findAny();
        System.out.println("\n16.Any element: " + findAny.orElse("none"));

        // 17. min() - Find the minimum element (lexicographically)
        Stream<String> stringStream13 = Stream.of("One", "Two", "Three", "Four");
        Optional<String> minElement = stringStream13.min(Comparator.naturalOrder());
        System.out.println("\n17.Min element: " + minElement.orElse("none"));

        // 18. max() - Find the maximum element (lexicographically)
        Stream<String> stringStream14 = Stream.of("One", "Two", "Three", "Four");
        Optional<String> maxElement = stringStream14.max(Comparator.naturalOrder());
        System.out.println("\n18.Max element: " + maxElement.orElse("none"));

        // 19. count() - Count the number of elements
        Stream<String> stringStream15 = Stream.of("One", "Two", "Three", "Four");
        long count = stringStream15.count();
        System.out.println("\n19.Element count: " + count);

        // 20. collect() - Collect the stream elements into a List
        Stream<String> stringStream16 = Stream.of("One", "Two", "Three", "Four");
        List<String> stringList = stringStream16.collect(Collectors.toList());
        System.out.println("\n20.Stream elements: " +stringList);
    }
}
