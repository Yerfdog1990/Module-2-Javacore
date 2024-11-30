package Deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample1 {
    /*
What is Deadlock in Multithreading?
Deadlock in multithreading occurs when two or more threads are waiting for each other to release resources, preventing further progress.
It is a state where the involved threads cannot proceed because each thread holds a resource the other thread needs.

Key Characteristics of Deadlock:
1.Mutual Exclusion: At least one resource is held in a non-shareable mode.
2.Hold and Wait: A thread holding at least one resource is waiting to acquire additional resources held by other threads.
3.No Preemption: A resource cannot be forcibly removed from a thread holding it.
4.Circular Wait: A circular chain of threads exists where each thread waits for a resource that the next thread in the chain holds.
     */
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        //Thread 1 trying to acquire lock1 then lock2
        Thread thread1 = new Thread(()->{
            //Lock1 acquiring lock
            lock1.lock();
            try{
                System.out.printf("%s trying to acquire lock%n", Thread.currentThread().getName());
                Thread.sleep(1000);

                //Thread1 trying to acquire lock2
                System.out.println("Thread 1 trying to acquire lock2");
                lock2.lock(); //Waiting for lock2
                System.out.printf("%s trying to acquire lock%n", Thread.currentThread().getName());
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.printf("%s was interrupted", Thread.currentThread().getName());
            }
            lock1.unlock();
            lock2.unlock();
        });

        //Thread 2 trying to acquire lock2 then lock1
        Thread thread2 = new Thread(()->{
            //Lock2 acquiring lock
            lock2.lock();
            try{
                System.out.printf("%s trying to acquire lock%n", Thread.currentThread().getName());
                Thread.sleep(1000);

                //Thread2 trying to acquire lock1
                System.out.println("Thread 2 trying to acquire lock1");
                lock1.lock(); //Waiting for lock2
                System.out.printf("%s trying to acquire lock%n", Thread.currentThread().getName());
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.printf("%s was interrupted", Thread.currentThread().getName());
            }
            lock1.unlock();
            lock2.unlock();
        });

        //Start thread
        thread1.start();
        thread2.start();

        //Both threads are stuck waiting for each other's locks,
        // and the program will not terminate unless forcefully stopped.

        /*
        Preventing Deadlock
        To avoid deadlock, consider the following strategies:
        1.Lock Ordering: Always acquire locks in a consistent order.
        2.Timeouts: Use tryLock with a timeout to avoid indefinite waiting.
        3.Deadlock Detection: Monitor the application for circular wait conditions.
        4.Avoid Nested Locks: Minimize the use of nested synchronized blocks or locks.
         */
    }
}
