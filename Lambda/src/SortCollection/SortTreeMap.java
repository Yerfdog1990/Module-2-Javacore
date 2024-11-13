package SortCollection;

import java.util.Collections;
import java.util.TreeMap;

public class SortTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Godfrey", 34);
        treeMap.put("John", 4);
        treeMap.put("Cyril", 5);
        treeMap.put("Peter", 34);
        treeMap.put("Tom", 14);
        treeMap.put("Abby", 6);

        //Prints based on natural order of alphabets
        System.out.println(treeMap);

        TreeMap<Integer, String> treeMap1 = new TreeMap<>();
        treeMap1.put(34,"Godfrey");
        treeMap1.put(4,"John");
        treeMap1.put(5,"Cyril");
        treeMap1.put(34,"Peter");
        treeMap1.put(14,"Tom");
        treeMap1.put(6,"Abby");

        //Prints based on natural order of numbers
        System.out.println(treeMap1);
    }
}
