package Deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockPreventionNoNestedLocks {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Runnable task1 = () -> {
            try {
                lock1.lock();
                System.out.println("Thread 1 acquired lock1");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } finally {
                lock1.unlock();
            }

            try {
                lock2.lock();
                System.out.println("Thread 1 acquired lock2");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } finally {
                lock2.unlock();
            }
        };

        Runnable task2 = () -> {
            try {
                lock2.lock();
                System.out.println("Thread 2 acquired lock2");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } finally {
                lock2.unlock();
            }

            try {
                lock1.lock();
                System.out.println("Thread 2 acquired lock1");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } finally {
                lock1.unlock();
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }
}
