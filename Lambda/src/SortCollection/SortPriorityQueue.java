package SortCollection;

import java.util.PriorityQueue;

public class SortPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>();
        stringPriorityQueue.add("Kenya");
        stringPriorityQueue.add("Uganda");
        stringPriorityQueue.add("Tanzania");
        stringPriorityQueue.add("Rwanda");
        stringPriorityQueue.add("Burundi");
        stringPriorityQueue.add("Ethiopia");

        // Print elements in natural order using poll
        while(!stringPriorityQueue.isEmpty()){
            System.out.println(stringPriorityQueue.poll()+ "");
        }
    }
}
