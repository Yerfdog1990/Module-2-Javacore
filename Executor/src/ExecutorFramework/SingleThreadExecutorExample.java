package ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Java Executor Framework
Java Executor Framework (introduced in JDK 5) is a powerful tool for managing concurrent tasks.
It provides an abstraction for executing Runnable tasks without manually creating new threads each time.
Instead, it uses a pool of worker threads that can be reused to handle incoming tasks more efficiently.

Why Use the Executor Framework?
    1.Efficiency: Reuses existing threads, reducing the overhead of thread creation and destruction.
    2.Scalability: Manages a pool of threads to handle multiple tasks concurrently.
    3.Flexibility: Provides different types of executors tailored for specific needs.
    4.Task Queueing: Excess tasks are stored in a queue and processed when threads become available.

Types of Executors in Java
Java provides several types of executors via the Executors class in java.util.concurrent.
Each type is suited for different use cases.
    1.SingleThreadExecutor: Executes tasks sequentially with a single worker thread. Useful when tasks must be executed one at a time in a specific order.
    2.FixedThreadPool
    3.CachedThreadPool
    4.ScheduledExecutor
 */
public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 10; i++) {
            final int taskNumber = i;
            executor.execute(()->{
                System.out.println("Executing task " +taskNumber+ " by " +Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}
