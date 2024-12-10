package ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
CachedThreadPool
Description:
Creates new threads as needed and reuses previously constructed threads when available.
Suitable for executing many short-lived tasks.
 */
public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i <= 5; i++) {
            final int taskNumber = i;
            executor.execute(()->{
                System.out.println("Execute task " +taskNumber+ " by " +Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}
