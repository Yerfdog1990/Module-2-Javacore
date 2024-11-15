package SortCollection;

import java.util.*;

public class Data {
    public static void main(String[] args) {
        //Array of integers
        Integer[] scores = {23, 78, 12, 90, 63, 78, 57, 13, 5, 102, 100, 48};
        //Covert array to list
        List<Integer> scoreList = new ArrayList<>(Arrays.asList(scores));
        //Print list before sorting
        System.out.print("Unsorted list: " );
        for(Integer elem : scoreList){
            System.out.print(elem+ ", ");
        }
        //Sorting in ascending order
        Collections.sort(scoreList, (o1,o2) -> (o1 - o2));
        //Print list in ascending order
        System.out.print("\nAscending ordered list: " );
        for(Integer elem : scoreList){
            System.out.print(elem+ ", ");
        }
        //Sorting in descending order
        Collections.sort(scoreList, (o1,o2) -> (o2 - o1));
        //Print list in ascending order
        System.out.print("\nDescending ordered list: " );
        for(Integer elem : scoreList){
            System.out.print(elem+ ", ");
        }
    }
}
