package ThreadPoolExecutor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkStealingPool {
    public static void main(String[] args) throws InterruptedException{
        // Use newWorkStealingPool with specified parallelism level
        ExecutorService executor = Executors.newWorkStealingPool(4);
        // Create a collection of tasks to execute
        Collection<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
            Callable<Void> callable = ()->{
                System.out.printf("Process task #%d on thread id%d.\n", taskNumber, Thread.currentThread().getId());
                TimeUnit.SECONDS.sleep(1); // Simulate task processing time
                return null;
            };
            tasks.add(callable);
        }
        try{
            executor.invokeAll(tasks);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        System.out.println("All tasks have been processed.");
    }
}
