package Volatile;
/*
Definition of the volatile Keyword in Java:
The volatile keyword in Java is used to indicate that a variable's value may be changed by multiple threads.
It ensures that changes to a variable made by one thread are immediately visible to other threads.
It prevents the compiler or the CPU from caching the variable, guaranteeing that every read of the variable reflects its most recent value.

Features of the volatile Keyword:
1.Visibility:
-Changes made to a volatile variable by one thread are immediately visible to other threads.
-Prevents threads from using outdated values cached in thread-local memory.
2.Atomicity:
-It does not make compound operations (like increment) atomic. For example, x++ is not thread-safe with volatile.
3.No Locking:
-Does not involve locks, so it is faster than synchronized. However, it doesn't provide mutual exclusion.
4.Prevent Instruction Reordering:
-Ensures the order of reads and writes to the volatile variable is maintained, which is important in multithreading.
 */
public class VolatileDemo {
    // Shared volatile variable
    private static volatile boolean flag = true;
    //Main method
    public static void main(String[] args) {
        // Thread that monitors the flag and stops when flag becomes false
        Thread monitorThread = new Thread(()->{
            while(flag){
                // Busy-wait until flag becomes false
            }
            System.out.println("Monitor thread has detected flag change!");
        });
        //Start monitorThread
        monitorThread.start();

        try {
            // Let the monitor thread run for a while
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Change the flag value
        System.out.println("Main thread is setting flag to false.");
        flag = false;
    }
}
