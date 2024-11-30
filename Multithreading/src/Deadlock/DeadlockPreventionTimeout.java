package Deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockPreventionTimeout {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            try {
                if (lock1.tryLock(2, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Thread 1 acquired lock1");
                        Thread.sleep(100);

                        if (lock2.tryLock(2, TimeUnit.SECONDS)) {
                            try {
                                System.out.println("Thread 1 acquired lock2");
                            } finally {
                                lock2.unlock();
                            }
                        } else {
                            System.out.println("Thread 1 could not acquire lock2");
                        }
                    } finally {
                        lock1.unlock();
                    }
                } else {
                    System.out.println("Thread 1 could not acquire lock1");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                if (lock2.tryLock(2, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Thread 2 acquired lock2");
                        Thread.sleep(100);

                        if (lock1.tryLock(2, TimeUnit.SECONDS)) {
                            try {
                                System.out.println("Thread 2 acquired lock1");
                            } finally {
                                lock1.unlock();
                            }
                        } else {
                            System.out.println("Thread 2 could not acquire lock1");
                        }
                    } finally {
                        lock2.unlock();
                    }
                } else {
                    System.out.println("Thread 2 could not acquire lock2");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
