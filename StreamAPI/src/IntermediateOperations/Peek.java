package IntermediateOperations;


import java.util.List;
import java.util.stream.Collectors;

public class Peek {
    public static void main(String[] args) {
        List<String> list = List.of("Kenya", "Uganda", "Tanzania", "Rwanda", "Burundi");
        System.out.printf("Original List: %s%n", list);
        System.out.printf("Peek List: %s%n", list.stream().peek(System.out::println).collect(Collectors.toList()));
    }
}
