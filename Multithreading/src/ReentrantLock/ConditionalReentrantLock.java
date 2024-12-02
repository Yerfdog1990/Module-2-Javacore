package ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// A class that demonstrates using threads to print even and odd numbers
// using ReentrantLock and Condition for thread synchronization.
public class ConditionalReentrantLock extends Thread{
    // A lock to synchronize the threads
    ReentrantLock lock = new ReentrantLock();
    // Condition variables to manage even and odd threads
    Condition odd = lock.newCondition();
    Condition even = lock.newCondition();

    // The current number to be printed
    int t;
    // Constructor to initialize the starting value of 't'
    public ConditionalReentrantLock(int t) {
        this.t = t;
    }
    // Default constructor starting from 0
    public ConditionalReentrantLock() {
        this.t = 0;
    }
    // Maximum number up to which the threads will print numbers
    int MAX_COUNT = 10;
    // The code to be run when the thread starts
    @Override
    public void run() {
        // Keep running until the current number exceeds MAX_COUNT
        while(t <= MAX_COUNT){
            // Acquire the lock to ensure only one thread accesses the code at a time
            lock.lock();
            try {
                // If it's an odd number and the current thread is the "even" thread,
                // the "even" thread waits.
                if(t % 2 == 1 && Thread.currentThread().getName().equals("even")){
                    even.await();
                }
                // If it's an even number and the current thread is the "odd" thread,
                // the "odd" thread waits.
                else if (t % 2 == 0 && Thread.currentThread().getName().equals("odd")) {
                    odd.await();
                    // Otherwise, the thread processes the current number
                }else{
                    // Print the thread name and the current number
                    System.out.printf("%s, Thread %d.%n", Thread.currentThread().getName(), t);
                    // Increment the number
                    t += 1;

                    // If the next number is even, signal the "even" thread
                    if(t % 2 == 0){
                        even.signal();
                        // If the next number is odd, signal the "odd" thread
                    } else if (t % 2 == 1) {
                        odd.signal();
                    }
                }
                // Handle any interruptions
            }catch (InterruptedException e){
                System.out.printf("%s was interrupted.%n", Thread.currentThread().getName());
            }finally {
                // Release the lock so the other thread can access it
                lock.unlock();
            }
        }
    }
    // The main method where the program starts
    public static void main(String[] args) {
        // Create an object with the starting number set to 5
        ConditionalReentrantLock obj = new ConditionalReentrantLock(5);

        // Create two threads for even and odd numbers, sharing the same object
        Thread evenThread = new Thread(obj, "even");
        Thread oddThread = new Thread(obj, "odd");

        //Start thread
        evenThread.start();
        oddThread.start();
    }
}
