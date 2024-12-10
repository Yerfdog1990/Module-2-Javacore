package ThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class FixedThreadPool implements Runnable{
    private int taskNumber;

    public FixedThreadPool(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName()+ " was interrupted.");
        }
        System.out.printf("Processed request #%d on %s, id%d.\n", taskNumber, Thread.currentThread().getName(), Thread.currentThread().getId());
    }

    public static void main(String[] args) throws InterruptedException{
        ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "MyThread");
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        });
        for (int i = 0; i < 100; i++) {
            executor.execute(new FixedThreadPool(i));
        }
        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();
        System.out.println(executor);
    }
}
/*
We can see that when the program ends, 15 tasks are done, but the pool still had 3 active threads that did not finish executing their tasks. The interrupt() method is called on these three threads, which means that the task will complete, but in our case, the sleep method throws an InterruptedException. We also see that after the shutdownNow() method is called, the task queue is cleared.
So when using an ExecutorService with a fixed number of threads in the pool, be sure to remember how it works. This type is suitable for tasks with a known constant load.
Here's another interesting question: if you need to use an executor for a single thread, which method should you call? newSingleThreadExecutor() or newFixedThreadPool(1)?
Both executors will have equivalent behavior. The only difference is that the newSingleThreadExecutor() method will return an executor that cannot be later reconfigured to use additional threads.
 */