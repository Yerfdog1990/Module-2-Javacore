package LockFramework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockFrameworkExample {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment(){
        lock.lock(); // Explicit locking
        try {
            ++count;
            System.out.println(Thread.currentThread().getName()+ " incremented to " +count);
        }finally {
            lock.unlock(); // Always unlock in a finally block to avoid deadlocks
        }
    }

    public void safeTryLock(){
        if(lock.tryLock()){
            try {
                System.out.println(Thread.currentThread().getName()+ " acquired lock via tryLock.");
                // Perform critical section work
            }finally {
                lock.unlock();
            }
        }else{
            System.out.println(Thread.currentThread().getName()+ " cannot acquire lock via tryLock.");
        }
    }
    //Main method
    public static void main(String[] args) {
        LockFrameworkExample example = new LockFrameworkExample();

        // Runnable task for threads
        Runnable task = ()->{
            for (int i = 0; i < 5; i++) {
                example.increment();
            }
            example.safeTryLock();
        };
        // Create and start threads
        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");

        // Start threads
        thread1.start();
        thread2.start();

    }
}

