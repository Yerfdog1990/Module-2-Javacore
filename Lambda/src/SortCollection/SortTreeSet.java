package SortCollection;

import java.util.Collections;
import java.util.TreeSet;

public class SortTreeSet{
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>((o1, o2) -> o2.compareTo(o1));
        treeSet.add("John");
        treeSet.add("Grace");
        treeSet.add("Meshack");
        treeSet.add("Godfrey");
        treeSet.add("Cyril");
        treeSet.add("Cyrek");
        treeSet.add("Junior");

        ////Prints reverse order of alphabets
        System.out.println("Name of students: " +treeSet);

    }
}
