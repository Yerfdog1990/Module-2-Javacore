package ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;

/*
ScheduledExecutor
Description:
Executes tasks after a specified delay or periodically at fixed intervals.
Useful for scheduling tasks like cron jobs.
 */
public class ScheduledExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = ()-> System.out.println("Task executed at " +System.currentTimeMillis());
        // Schedule the task to run after a 3-second delay
        executor.schedule(task, 3, TimeUnit.SECONDS);
        // Schedule the task to run periodically every 2 seconds, starting after a 1-second delay
        executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
        // Shutdown after 10 seconds
        executor.schedule(()->executor.shutdown(), 10, TimeUnit.SECONDS);
    }
}
