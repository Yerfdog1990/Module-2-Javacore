package ThreadPoolExecutor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkStealingPool2 {
    public static void main(String[] args) throws InterruptedException{
        //Default Parallelism: The parallelism level is set to the number of available
        // processor cores using Runtime.getRuntime().availableProcessors().
        ExecutorService executor = Executors.newWorkStealingPool();
        Collection<Callable<Void>> tasks = new ArrayList<>();
        //Create tasks
        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
        Callable<Void> callable = ()->{
                System.out.printf("Requested task #%d on thread id%d.\n", taskNumber, Thread.currentThread().getId());
                TimeUnit.SECONDS.sleep(1);
                return null;
            };
            tasks.add(callable);
        }
        try {
            executor.invokeAll(tasks);
        }catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName()+ " was interrupted.\n");
        }finally {
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        System.out.println("All tasks have been executed.");
    }
}
