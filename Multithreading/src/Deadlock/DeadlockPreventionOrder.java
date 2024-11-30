package Deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockPreventionOrder {
    public static void main(String[] args) {
        // Shared locks representing resources
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        // Thread 1 acquires locks in the same order
        Thread thread1 = new Thread(() -> {
            try {
                lock1.lock();
                System.out.println("Thread 1 acquired lock1");
                Thread.sleep(100);

                lock2.lock();
                System.out.println("Thread 1 acquired lock2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        });

        // Thread 2 also acquires locks in the same order
        Thread thread2 = new Thread(() -> {
            try {
                lock1.lock();
                System.out.println("Thread 2 acquired lock1");
                Thread.sleep(100);

                lock2.lock();
                System.out.println("Thread 2 acquired lock2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        });

        thread1.start();
        thread2.start();
    }
}
