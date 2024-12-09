package CallableandFuture;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SquareNumbers implements Callable {
    private int number;

    public SquareNumbers(int number) {
        this.number = number;
    }

    @Override
    public Object call() throws Exception {
        int result = number * number;
        return result;
    }
}
class CalculateSquareNumbers{
    public static void main(String[] args) throws Exception{
        try(Scanner number = new Scanner(System.in)){
            System.out.print("Enter the number: ");
            int userInput = number.nextInt();
            FutureTask<Integer> futureTask = new FutureTask<>(new SquareNumbers(userInput));
            new Thread(futureTask).start();
            int result;
            if(futureTask.isDone()){
                result = futureTask.get();
            }else{
                try{
                    result = futureTask.get(100, TimeUnit.MILLISECONDS);
                }catch (TimeoutException e){
                    //Interrupt the task
                    futureTask.cancel(true);
                    System.out.println(userInput+ " * " +userInput+ " could not be computed within the allotted time. ");
                }
            }
            System.out.println(userInput+ " * " +userInput+ " = " +futureTask.get());
        }
    }
}
