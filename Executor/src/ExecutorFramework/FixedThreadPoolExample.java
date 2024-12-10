package ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
FixedThreadPool
Description:
Executes tasks using a fixed number of worker threads.
Suitable for scenarios where the number of concurrent tasks is known in advance.
 */
public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i <= 5; i++) {
            final int taskNumber = i;
            executor.execute(()->{
                System.out.println("Executing task " +taskNumber+ " by " +Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}
