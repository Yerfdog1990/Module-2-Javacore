package IntermediateOperations;

import java.util.List;
import java.util.stream.Collectors;

public class Mapping {
    public static void main(String[] args) {
        List<String> list = List.of("Kenya", "Uganda", "Tanzania", "Rwanda", "Burundi");
        //Print original list
        System.out.printf("Original List: %s%n", list);
        //Mapped list String transformation
        System.out.printf("Mapped List, uppercase: %s%n", list.stream().map(String::toUpperCase).collect(Collectors.toList()));
        System.out.printf("Mapped List, lowercase: %s%n", list.stream().map(String::toLowerCase).collect(Collectors.toList()));
        System.out.printf("Mapped List, length: %s%n", list.stream().map(String::length).collect(Collectors.toList()));
        System.out.printf("Mapped List, contains \'a\': %s%n", list.stream().map(s->s.contains("a")).collect(Collectors.toList()));
        System.out.printf("Mapped List, length > 5: %s%n", list.stream().map(s->s.length() > 5).collect(Collectors.toList()));
        System.out.printf("Mapped List, trim: %s%n", list.stream().map(String::trim).collect(Collectors.toList()));
        System.out.printf("Mapped List, replace \'a\' with \'x\': %s%n", list.stream().map(s->s.replace("a", "x")).collect(Collectors.toList()));
        System.out.printf("Mapped List, substring \'a\' to \'c\': %s%n", list.stream().map(s->s.substring(1, 3)).collect(Collectors.toList()));
        System.out.printf("Mapped List, split \'a\' to \'c\': %s%n", list.stream().map(s->String.join(", ", s.split("a"))).collect(Collectors.toList()));
        System.out.printf("Mapped List, concat \'a\' to \'c\': %s%n ", list.stream().map(s->s.concat("a")).collect(Collectors.toList()));
    }
}
