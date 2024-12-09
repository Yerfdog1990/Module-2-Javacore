package CallableandFuture;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Fibonacci implements Callable {
    private final int index;

    public Fibonacci(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public Object call() throws Exception {
        int first = 0;
        int second = 1;
        if(index == 0){
            return first;
        } else if (index == 1) {
            return second;
        }else{
            for (int i = 0; i < index-2; i++) {
                int temp = second;
                second += first;
                first = temp;
            }
        }
        return second;
    }
    public static Future<Integer> calculateAsync(int index) throws Exception{
        Fibonacci fibonacci = new Fibonacci(index);
        FutureTask<Integer> futureTask = new FutureTask<>(fibonacci);
        Thread thread = new Thread(futureTask);
        thread.start();
        return futureTask;
    }
}
class CallableandFutureDemo{

    public static void main(String[] args) throws Exception{
        Map<Integer, Future<Integer>> tasks = new HashMap<>();
        for (int i = 10; i < 20; i++) {
            tasks.put(i, Fibonacci.calculateAsync(i));
        }
        for(Map.Entry<Integer, Future<Integer>> entry : tasks.entrySet()){
            // Correctly retrieve the index from the map key
            int index = entry.getKey();
            Future<Integer> task = entry.getValue();
            int result;
            // Check whether the task is done
           if(task.isDone()){
               result = task.get();
           }else{
               try{
                   // Wait another 100 milliseconds for the result of the calculations
                   result = task.get(100, TimeUnit.MILLISECONDS);
               }catch (TimeoutException e){
                   // Interrupt the task
                   task.cancel(true);
                   System.out.println("Fibonacci number " + index + " could not be calculated in the allotted time.");
                   continue;
               }
           }
            System.out.println("Fibonacci number " + index + ": " + result);
        }
    }
}
