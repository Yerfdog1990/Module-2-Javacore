package IntermediateOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapping {
    private String name;
    public Mapping(String name1) {
        this.name = name1;
    }
    //Setter
    public String getName() {
        return name;
    }
    public static void main(String[] args) {
        List<String> list = List.of("Kenya", "Uganda", "Tanzania", "Rwanda", "Burundi");
        //Print, original list
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
        System.out.printf("Mapped List, indexOf \'a\' > 3: %s%n", list.stream().map(s->s.indexOf("a") > 3).collect(Collectors.toList()));

        //Mapped list, Numerical Transformations
        List<String> list2 = List.of("123", "456", "789", "012", "345");
        System.out.printf("Mapped List, Integer: %s%n", list2.stream().map(Integer::parseInt).collect(Collectors.toList()));
        System.out.printf("Mapped List, Double: %s%n", list2.stream().map(Double::parseDouble).collect(Collectors.toList()));
        List<Integer> list3 = List.of(123, 456, 789, 12, 345);
        System.out.printf("Mapped List, arithmetic transformation: %s%n", list3.stream().map(i->i*2).collect(Collectors.toList()));
        List<Double> list4 = List.of(123.45, 456.78, 789.12, 12.34, 345.67);
        System.out.printf("Mapped List, arithmetic transformation: %s%n", list4.stream().map(d->d/2).collect(Collectors.toList()));
        List<String> list5 = List.of("123.45", "456.78", "789.12", "12.34", "345.67");
        System.out.printf("Mapped List, arithmetic transformation: %s%n", list5.stream().map(Double::valueOf).collect(Collectors.toList()));
        System.out.printf("Mapped List, square root: %s%n", list3.stream().map(Math::sqrt).collect(Collectors.toList()));

        //Object Transformations
        List<Mapping> mappingList = List.of(new Mapping("Godfrey"), new Mapping("Okoth"), new Mapping("Ouma"));
        System.out.printf("Mapped List, getName: %s%n", mappingList.stream().map(Mapping::getName).collect(Collectors.toList()));
        System.out.printf("Mapped List, convert Object to string: %s%n", list3.stream().map(Object::toString).collect(Collectors.toList()));
        System.out.printf("Mapped List, reversed string: %s%n", list.stream().map(s->new StringBuilder(s).reverse().toString()).collect(Collectors.toList()));

        //Boolean Transformations
        System.out.printf("Mapped List, contains \'a\': %s%n", list.stream().map(s->s.contains("a")).collect(Collectors.toList()));
        System.out.printf("Mapped List, starts with \'K\': %s%n", list.stream().map(s->s.startsWith("K")).collect(Collectors.toList()));
        System.out.printf("Mapped List, ends with \'a\': %s%n", list.stream().map(s->s.endsWith("a")).collect(Collectors.toList()));

        //General Data Type Transformations
        List<String> list6 = List.of("a", "b", "c", "d", "e");
        System.out.printf("Mapped List, split \'a\' to \'c\': %s%n", list6.stream().map(s->String.join(", ", s.split(""))).collect(Collectors.toList()));
        System.out.printf("Mapped List, concat \'a\' to \'c\': %s%n ", list6.stream().map(s->s.concat("a")).collect(Collectors.toList()));
        System.out.printf("Mapped List, custom transformation: %s%n", list6.stream().map(s->s.toUpperCase().concat("a")).collect(Collectors.toList()));
        System.out.printf("Mapped List, custom transformation: %s%n", list6.stream().map(s->s+s.toUpperCase()).collect(Collectors.toList()));
    }
}
