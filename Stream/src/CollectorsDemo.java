import java.util.*;
import java.util.stream.Collectors;

/*
Purpose: Collect method in Java transforms a stream into a specific collection (e.g., List, Set, Map).
Takes a Collector: The collect() method accepts a collector object that gathers elements from the stream.
Collector Type: The collector has the type Collector<T, A, R>, where:
    T: Type of stream elements.
    A: Type of accumulator used internally during collection.
    R: Type of the final result (often List<T>, Set<T>, or Map<K, V>).
Return Value: The method returns the collection specified by the collector, such as a List, Set, Map, etc.
 */
public class CollectorsDemo {
    public static void main(String[] args) {

        ArrayList<String> arrayList1 = new ArrayList<>();
        Collections.addAll(arrayList1, "hello", "Java", "Programming", "welcome");

        //1.Converting a stream to a list
        List <String> stringList = arrayList1.stream()
                .filter(str ->Character.isUpperCase(str.charAt(0)))
                .collect(Collectors.toList());
        stringList.forEach(System.out::println);

        //2.Converting a stream to a set
        Set <String> stringSet = stringList.stream()
                .filter(str ->Character.isUpperCase(str.charAt(0)))
                .collect(Collectors.toSet());
        stringSet.forEach(System.out::println);

        //3.Converting a stream to a map
        ArrayList<String> arrayList2 = new ArrayList<>();
        Collections.addAll(arrayList2, "a=1", "b=2", "c=3", "d=4");
        Map<String, String> stringMap = arrayList2.stream()
                .map(e -> e.split("="))
                .filter(e -> e.length ==2)
                .collect(Collectors.toMap(e->e[0], e->e[1]));
        stringMap.forEach((key, value) ->System.out.println(key + " = " +value));

        //4.Converting a stream to a string
        String result = arrayList2.stream()
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
