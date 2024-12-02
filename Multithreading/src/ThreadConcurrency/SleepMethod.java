package ThreadConcurrency;
/*
In Java, the sleep() method belongs to the Thread class and is used to pause the execution of the current thread for a specified duration.
Unlike yield(), sleep() causes the thread to enter the Timed Waiting state for the given period.

Features of sleep() in Java:
1.Pause Execution: It pauses the current thread for a specified number of milliseconds or nanoseconds.
2.Guaranteed Pause: The thread will not execute during the sleep period unless interrupted.
3.Checked Exception: The InterruptedException must be handled since other threads can interrupt the sleeping thread.
4.Static Method: sleep() affects the currently executing thread, regardless of the instance it's called on.
5.Platform-independent: The sleep duration is generally accurate across platforms, but slight deviations can occur.
 */
public class SleepMethod implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+ " - Iteration: " +i);
            try {
                //Call Thread.sleep()
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //Main method
    public static void main(String[] args) {
        //Create thread objects
        Thread thread1 = new Thread(new SleepMethod(), "Thread-1");
        Thread thread2 = new Thread(new SleepMethod(), "Thread-2");

        //Start both threads
        thread1.start();
        thread2.start();
    }
}
