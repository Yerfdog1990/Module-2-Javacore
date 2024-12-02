package ThreadConcurrency;
/*
In Java, the join() method is a part of the Thread class, used to ensure that one thread completes its execution before another thread begins or continues execution.
When a thread calls the join() method on another thread, it pauses its execution and waits for the other thread to finish.

Features of join() in Java:
1.Thread Synchronization: Ensures sequential execution by waiting for the completion of a specified thread.
2.Blocking Method: The thread calling join() enters the Waiting state until the specified thread finishes.
3.Overloaded Variants:
    -join() (waits indefinitely until the thread finishes).
    -join(long millis) (waits for a specified time in milliseconds).
    -join(long millis, int nanos) (waits for a specified time in milliseconds and nanoseconds).
4.Checked Exception: The InterruptedException must be handled, as the waiting thread might be interrupted.
 */
public class JoinMethod extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+ " - Iteration: " +i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //Main method
    public static void main(String[] args) {
        //Creating thread objects
        Thread thread1 = new Thread(new JoinMethod(), "Thread-1");
        Thread thread2 = new Thread(new JoinMethod(), "Thread-2");

        //Start thread1
        System.out.println("Start running Thread-1");
        thread1.start();
        System.out.println("Thread-1 is still alive? " +thread1.isAlive());

        try {
            // Ensuring thread1 finishes before starting thread2
            thread1.join();
            System.out.println("Thread-1 is still alive? " +thread1.isAlive());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Start thread2
        System.out.println("\nStart running Thread-2");
        thread2.start();
        System.out.println("Thread-2 is still alive? " +thread2.isAlive());

        try {
            // Ensuring thread1 finishes before the main thread proceeds.
            thread2.join();
            System.out.println("Thread-2 is still alive? " +thread2.isAlive());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nAll threads have finished.");
    }
}
