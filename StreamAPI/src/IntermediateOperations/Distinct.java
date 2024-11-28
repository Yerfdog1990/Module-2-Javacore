package IntermediateOperations;

import java.util.List;

public class Distinct {
    public static void main(String[] args) {
        List<String> list = List.of("Kenya", "Uganda", "Tanzania", "Rwanda", "Burundi");
        list.stream().distinct().forEach(System.out::println);
    }
}
