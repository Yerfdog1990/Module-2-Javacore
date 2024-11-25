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
        System.out.printf("Sorted List, natural order: %s%n", list.stream().sorted().collect(Collectors.toList()));
        System.out.printf("Sorted List, reverse order: %s%n", list.stream().sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList()));
        System.out.printf("Sorted List, case insensitive: %s%n", list.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList()));
        System.out.printf("Sorted List, length ascending: %s%n", list.stream().sorted((s1, s2) -> s1.length() - s2.length()).collect(Collectors.toList()));
        System.out.printf("Sorted List, length descending: %s%n", list.stream().sorted((s1, s2) -> s2.length() - s1.length()).collect(Collectors.toList()));
        System.out.printf("Sorted List, alphabetical ascending: %s%n", list.stream().sorted().collect(Collectors.toList()));
        System.out.printf("Sorted List, alphabetical descending: %s%n", list.stream().sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList()));
        System.out.printf("Sorted List, chained comparator: %s%n", list.stream().sorted(String.CASE_INSENSITIVE_ORDER.thenComparing(String.CASE_INSENSITIVE_ORDER)).collect(Collectors.toList()));
    }
}
