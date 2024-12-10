package ThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class CachedThreadPool implements Runnable{
    private int taskNumber;

    public CachedThreadPool(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        System.out.printf("Processed request #%d on %s, id%d.\n", taskNumber, Thread.currentThread().getName(), Thread.currentThread().getId());
    }
    public static void main(String[] args) throws InterruptedException{
        ExecutorService executor = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "MyThread");
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        });
        for (int i = 0; i < 10; i++) {
            executor.submit(new CachedThreadPool(i));
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(executor);
        TimeUnit.SECONDS.sleep(30);
        executor.submit(new CachedThreadPool(3));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(executor);
        TimeUnit.SECONDS.sleep(70);
        for (int i = 4; i < 7; i++) {
            executor.submit(new CachedThreadPool(i));
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(executor);
        executor.shutdown();
    }
}
