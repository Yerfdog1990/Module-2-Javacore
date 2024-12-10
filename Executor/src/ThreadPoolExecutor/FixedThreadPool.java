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
            Thread.sleep(1000);
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
        for (int i = 0; i < 10; i++) {
            executor.execute(new FixedThreadPool(i));
        }
        executor.awaitTermination(30, TimeUnit.SECONDS);
        executor.shutdown();
    }
}
