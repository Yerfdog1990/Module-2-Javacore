package CallableandFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;


public class SquareNumbers implements Callable {
    private int number;

    public SquareNumbers(int number) {
        this.number = number;
    }

    @Override
    public Object call() throws Exception {
        return number * number;
    }
    public static Future<Integer> calculateAsync(int number){
        FutureTask<Integer> futureTask = new FutureTask<>(new SquareNumbers(number));
        new Thread(futureTask).start();
        return futureTask;
    }
}

class CalculateSquareNumbers{
    public static void main(String[] args) throws Exception{
        try(Scanner number = new Scanner(System.in)){
            System.out.print("Enter the number: ");
            int userInput = number.nextInt();
            // List to store Future results
            List<Future<Integer>> futureList = new ArrayList<>();
            // Submit tasks asynchronously
            for (int i = 1; i <= userInput; i++) {
                futureList.add(SquareNumbers.calculateAsync(i));
            }
            // Print each result
            for (int i = 1; i <= userInput; i++) {
                Future<Integer> task = futureList.get(i-1);
                Integer square;
                if(task.isDone()){
                    square = task.get();
                }else{
                    try{
                        square = task.get(100, TimeUnit.SECONDS);
                    }catch(TimeoutException e){
                        //Cancel task
                        task.cancel(true);
                        System.out.println("Task cancelled as square of " +i+ " could not be calculated within the allotted time.");
                        continue;
                    }
                }
                System.out.println(i+ " * " +i+ " = " +square);
            }
        }
    }
}
