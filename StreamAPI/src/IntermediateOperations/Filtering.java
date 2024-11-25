package IntermediateOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Kenya", "Uganda", "Tanzania", "Rwanda", "Burundi", "123");
        //Print original list
        System.out.printf("Original List: %s%n", list);

        //Print filtered list
        System.out.printf("Filtered List, starts with \'T\': %s%n", list.stream().filter(s -> s.startsWith("T")).collect(Collectors.toList()));
        System.out.printf("Filtered List, ends with \'i\': %s%n", list.stream().filter(s->s.endsWith("i")).collect(Collectors.toList()));
        System.out.printf("Filtered List, contains \'a\': %s%n", list.stream().filter(s->s.contains("a")).collect(Collectors.toList()));
        System.out.printf("Filtered List, contains \'a\' and ends with \'i\': %s%n", list.stream().filter(s->s.contains("a") && s.endsWith("i")).collect(Collectors.toList()));
        System.out.printf("Filtered List, contains \'a\' or ends with \'i\': %s%n", list.stream().filter(s->s.contains("a") || s.endsWith("i")).collect(Collectors.toList()));
        System.out.printf("Filtered List, starts with \'K\' and ends with \'a\': %s%n", list.stream().filter(s->s.startsWith("K") && s.endsWith("a")).collect(Collectors.toList()));
        System.out.printf("Filtered List, starts with \'K\' or ends with \'a\': %s%n", list.stream().filter(s->s.startsWith("K") || s.endsWith("a")).collect(Collectors.toList()));
        System.out.printf("Filtered List, is empty: %s%n", list.stream().filter(s->s.isEmpty()).collect(Collectors.toList()));
        System.out.printf("Filtered List, is not empty: %s%n", list.stream().filter(s->!s.isEmpty()).collect(Collectors.toList()));
        System.out.printf("Filtered List, equals \'Uganda\': %s%n", list.stream().filter(s->s.equals("Uganda")).collect(Collectors.toList()));
        System.out.printf("Filtered List, matches \'[a-zA-Z]+\': %s%n", list.stream().filter(s->s.matches("[a-zA-Z]+")).collect(Collectors.toList()));
        System.out.printf("Filtered List, matches \'\\d+\': %s%n", list.stream().filter(s->s.matches("\\d+")).collect(Collectors.toList()));
        System.out.printf("Filtered, List, indexOf \'a\' > 3: %s%n", list.stream().filter(s->s.indexOf("a") > 3).collect(Collectors.toList()));
        System.out.printf("Filtered List, length > 5: %s%n", list.stream().filter(s->s.length() > 5).collect(Collectors.toList()));
        System.out.printf("FiltredList, length < 5: %s%n", list.stream().filter(s->s.length() < 5).collect(Collectors.toList()));
    }
}
