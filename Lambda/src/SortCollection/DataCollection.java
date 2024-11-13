package SortCollection;

import java.util.ArrayList;
import java.util.Collections;

public class DataCollection {
    public static void main(String[] args) {
        ArrayList<Integer> age = new ArrayList<>();
        //Add data to collection
        age.add(14);
        age.add(16);
        age.add(12);
        age.add(19);
        age.add(13);
        //Print age pf students before sorting.
        System.out.println("Aage of students before sorting: " +age);

        //Sort using collection
        Collections.sort(age,(Obj1, Obj2)->(Obj1 > Obj2) ? -1 : (Obj1 < Obj2) ? 1 : 0);
        //print sorted list,
        System.out.println("Aage of students after sorting: " +age);
    }
}
