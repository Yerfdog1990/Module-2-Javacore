package SortCollection;

import java.util.Collections;
import java.util.TreeMap;

public class SortTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>((Obj1, Obj2)-> Obj1.compareTo(Obj2));
        treeMap.put("Godfrey", 34);
        treeMap.put("John", 4);
        treeMap.put("Cyril", 5);
        treeMap.put("Peter", 34);
        treeMap.put("Tom", 14);
        treeMap.put("Abby", 6);

        System.out.println(treeMap);


    }
}
