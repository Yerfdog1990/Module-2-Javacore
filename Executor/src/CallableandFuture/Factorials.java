package CallableandFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Factorials implements Callable {
    private Long number;

    public Factorials(Long number) {
        this.number = number;
    }

    @Override
    public Long call() throws Exception {
        long result = 1L;
        while (number > 1){
            result *= number;
            number--;
        }
        return result;
    }
}
class CalculateFactorials{
    public static void main(String[] args) throws Exception{
        //Pass Factorial anonymous class into FutureTask interface
        //Create objects of the FutureTask interface
        FutureTask<Long> futureTask1 = new FutureTask<>(new Factorials(5L));
        FutureTask<Long> futureTask2 = new FutureTask<>(new Factorials(7L));
        FutureTask<Long> futureTask3 = new FutureTask<>(new Factorials(9L));
        //Create and start threads
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        new Thread(futureTask3).start();
        //Print the output
        System.out.println("5! = " +futureTask1.get());
        System.out.println("7! = " +futureTask2.get());
        System.out.println("9! = " +futureTask3.get());
    }
}