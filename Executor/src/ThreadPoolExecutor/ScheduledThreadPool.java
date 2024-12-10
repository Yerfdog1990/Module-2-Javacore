package ThreadPoolExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool implements Runnable {
    @Override
    public void run() {
        System.out.println("Checking email.....");
    }

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        // Schedule the task to run periodically every 2 seconds, starting after a 1-second delay
        executor.scheduleAtFixedRate(new ScheduledThreadPool(), 0, 5, TimeUnit.SECONDS);
        //Shutdown after 10 seconds
        executor.schedule(()->executor.shutdown(), 10, TimeUnit.SECONDS);
    }
}
