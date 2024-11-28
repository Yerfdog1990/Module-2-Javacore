package IntermediateOperations;

import java.util.List;

public class Distinct {
    public static void main(String[] args) {
        List<String> list = List.of("Kenya", "Uganda", "Burundi", "Tanzania", "Kenya", "Rwanda", "Burundi");
        System.out.printf("Original List: %s%n", list);
        System.out.printf("Distinct List: %s%n", list.stream().distinct().collect(java.util.stream.Collectors.toList()));
    }
}
