package ThreadConcurrency;
/*
In Java, the yield() method is part of the Thread class, used to suggest to the thread scheduler that the current thread is willing to yield its current use of a processor.
It temporarily pauses its execution and allows other threads of the same or higher priority to execute.
However, it’s merely a suggestion, and the thread scheduler may or may not honor it.

Features of yield() in Java:
1.Non-blocking: The thread that calls yield() remains in the Runnable state, not Blocked or Waiting.
2.Voluntary Pause: It allows threads with equal or higher priority a chance to execute.
3.Platform-dependent: The behavior of yield() depends on the operating system and JVM implementation.
4.No Guarantee: There's no guarantee that another thread will get the CPU when yield() is called.
 */
public class YieldMethod extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+ " - Iteration: " +i);
            //Calling yield
            Thread.yield();
        }
    }
    //Main method
    public static void main(String[] args) {
        //Create thread objects
        Thread thread1 = new Thread(new YieldMethod(), "Thread-1");
        Thread thread2 = new Thread(new YieldMethod(), "Thread-2");

        //Start threads
        thread1.start();
        thread2.start();
    }
}
