package Interface;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface Runnable {
    void run();
}
class Timer implements Runnable{
    @Override
    public void run() {
        System.out.println("Current time: " + LocalDateTime.now());
    }
}
class Calendar implements Runnable{
    @Override
    public void run() {
        var day = LocalDateTime.now();
        System.out.println("Day of the week: " +day.getDayOfWeek());
    }
}
class MainClass{
    // ArrayList that holds Runnable objects
    public static ArrayList<Runnable> list = new ArrayList<>();
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.run();

        Calendar calendar = new Calendar();
        calendar.run();

        Runnable runnable1 = new Timer();
        runnable1.run();

        Runnable runnable2 = new Calendar();
        runnable2.run();

       //Add Runnable objects to the ArrayList
        list.add(new Timer());
        list.add(new Calendar());

        // Iterating over the list and calling the run() method on each object
        for(Runnable elem : list){
            elem.run(); // Calls the run() method from Timer and Calendar
        }
    }
}