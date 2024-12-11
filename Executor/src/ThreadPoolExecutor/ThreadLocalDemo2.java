package ThreadPoolExecutor;

import java.util.concurrent.*;

public class ThreadLocalDemo2 {
    // Define a ThreadLocal variable
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    // Custom ThreadPoolExecutor to handle ThreadLocal cleanup
  static class ThreadLocalAwareThreadPool extends ThreadPoolExecutor{
        public ThreadLocalAwareThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }
        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            // Clean up the ThreadLocal after task execution
            threadLocal.remove();
        }
    }
    // Task that uses ThreadLocal
    static class Task implements Runnable{
      private final int taskId;

      //Constructor
        public Task(int taskId) {
            this.taskId = taskId;
        }
        @Override
        public void run() {
            // Set a value in the ThreadLocal for this task
            threadLocal.set("Thread #" +taskId+ " executed by "+Thread.currentThread().getName());
            System.out.println(threadLocal.get());
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
    //Main method
    public static void main(String[] args) {
        // Create a custom ThreadPoolExecutor
        ExecutorService executor = new ThreadLocalAwareThreadPool(3,3,0L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        // Submit multiple tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            executor.submit(new Task(i));
            // Shutdown the executor
        }
        executor.shutdown();
        try{
            if(!executor.awaitTermination(10, TimeUnit.SECONDS));
                executor.shutdown();
        }catch (InterruptedException e){
            executor.shutdown();
        }
    }
}
