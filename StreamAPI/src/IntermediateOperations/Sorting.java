package IntermediateOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorting {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Kenya", "Uganda", "Tanzania", "Rwanda", "Burundi");
        //Print original list
        System.out.printf("Original List: %s%n", list);

        //Print sorted list
        System.out.printf("Sorted List: %s%n", list.stream().sorted().collect(Collectors.toList()));
    }
}
