package SortCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortList {
    public static void main(String[] args) {
        ArrayList<Integer> age = new ArrayList<>();
        //Add data to collection
        age.add(14);
        age.add(16);
        age.add(12);
        age.add(19);
        age.add(13);
        //Print age pf students before sorting.
        System.out.println("Aage of students (Unordered) before sorting: " +age);

        //Sort using anonymous class
        Comparator<Integer> ageComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        Collections.sort(age,ageComparator);
        System.out.println("Age after sorting (ascending) using anonymous class: " + age);

        //Sort using collection
        Collections.sort(age,(Obj1, Obj2)->(Obj1 - Obj2));
        //print sorted list
        System.out.println("Age after sorting (ascending) using lambda expression class: "  +age);

        //Sort using anonymous class
        Comparator<Integer> reverseComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        Collections.sort(age,reverseComparator);
        System.out.println("Age after sorting (descending) using anonymous class: " + age);

        //Sort using collection
        Collections.sort(age,(Obj1, Obj2)->(Obj2 - Obj1));
        //print sorted list
        System.out.println("Age after sorting (descending) using lambda expression class: "  +age);
    }
}
