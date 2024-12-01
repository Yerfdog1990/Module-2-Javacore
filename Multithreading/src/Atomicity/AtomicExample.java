package Atomicity;

import java.util.concurrent.atomic.AtomicInteger;

/*
Definition of Atomicity in Threads:
Atomicity ensures that a series of operations on a shared resource are performed as a single, indivisible step.
In multithreaded programming, an atomic operation is one that is completed entirely or not at all, preventing interference by other threads.
For example, in Java, simple reads and writes to int, long, and boolean variables are atomic.
However, compound actions like incrementing (x++) or decrementing are not atomic because they involve multiple steps: read, modify, and write.
To ensure atomicity in complex operations, we can use:
1.Synchronization mechanisms (synchronized blocks or methods).
2.Atomic variables from the java.util.concurrent.atomic package, such as AtomicInteger, AtomicLong, etc.

Characteristics of Atomicity:
1.Indivisibility: The operation is executed as a single step without interference from other threads.
2.Prevents Race Conditions: Ensures that no other thread can observe an intermediate state of the operation.
3.Achieved via:
    -Atomic classes like AtomicInteger.
    -Synchronization mechanisms (synchronized, ReentrantLock).
4.Useful for: Incrementing counters, swapping values, or performing checks and updates atomically.
 */
public class AtomicExample {
    private static final AtomicInteger counter1 = new AtomicInteger(0);
    private static int counter2 = 0;

    //Main method
    public static void main(String[] args) throws InterruptedException{
        //Create thread for incrementing using atomic classes
        Thread thread1 = new Thread(()-> incrementAtomicClass());
        Thread thread2 = new Thread(()-> incrementAtomicClass());

        //Start thread
        thread1.start();
        thread2.start();

        //Join threads
        thread1.join();
        thread2.join();

        // The counter will always be 20000 due to atomicity
        System.out.printf("Using atomic class. The final counter value (Atomic) = %d.%n", counter1.get());

        //Create threads for incrementing using synchronization
        Thread thread3 = new Thread(()-> incrementSyncronization());
        Thread thread4 = new Thread(()-> incrementSyncronization());

        //Start thread
        thread3.start();
        thread4.start();

        //Join threads
        thread3.join();
        thread4.join();

        // The counter will always be 20000 due to atomicity
        System.out.printf("Using synchronization. The final counter value (Atomic) = %d.%n", counter2);
    }
    //Achieve atomicity using atomic classes
    private static void incrementAtomicClass(){
        for (int i = 0; i < 10000; i++) {
            counter1.incrementAndGet(); // Atomic operation
        }
    }
    //Achieve atomicity using synchronization
    private static synchronized void incrementSyncronization(){
        for (int i = 0; i < 10000; i++) {
            counter2++;
        }
    }
}
