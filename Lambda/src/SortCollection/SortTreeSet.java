package SortCollection;

import java.util.Collections;
import java.util.TreeSet;

public class SortTreeSet{
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>((o1, o2) -> o1.compareTo(o2));
        treeSet.add("John");
        treeSet.add("Grace");
        treeSet.add("Meshack");
        treeSet.add("Godfrey");
        treeSet.add("Cyril");
        treeSet.add("Cyrek");
        treeSet.add("Junior");
        System.out.println(treeSet);

    }
}
