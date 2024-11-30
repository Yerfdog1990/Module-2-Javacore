package LockFramework;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample1 {
    // ReentrantLock for thread-safe access
    public final Lock lock = new ReentrantLock();

    //Method to perform task with lock
    public void performTaskWithLock(){
        lock.lock();//Acquiring lock
        try{
            System.out.printf("%s has acquired lock.%n", Thread.currentThread().getName());
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Thread has been interrupted.");
        }finally {
            lock.unlock();
            System.out.printf("%s has released lock.%n", Thread.currentThread().getName());
        }
    }
    //Method to perform a task wit tryLock
    public void performTaskWithTryLock(){
        // Try to acquire the lock
        if(lock.tryLock()){
            try {
                System.out.printf("%s has acquired lock using tryLock.%n", Thread.currentThread().getName());
                Thread.sleep(1000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted.");
            }finally {
                lock.unlock(); //Releasing lock
                System.out.printf("%s has released lock.%n", Thread.currentThread().getName());
            }
        }else{
            System.out.printf("%s could not acquire lock using tryLock.%n", Thread.currentThread().getName());
        }
    }
    //Perform task with timeout
    public void performTaskWithTimeout(){
        //Try to acquire lock with timeout
        try {
            if(lock.tryLock(2, TimeUnit.SECONDS)){
                try {
                    System.out.printf("%s has acquired lock using timeout.%n", Thread.currentThread().getName());
                    Thread.sleep(1000);
                }finally {
                    lock.unlock();
                    System.out.printf("%s has released lock using timeout.%n", Thread.currentThread().getName());
                }
            }else{
                System.out.printf("%s could not acquire lock using tryLock.%n", Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Perform task with interruptibleLock
    public void performTaskWithInterruptibleLock(){
        //Try to acquire lock with timeout
        try {
            lock.lockInterruptibly();
                try {
                    System.out.printf("%s has acquired lock using lockInterruptibly.%n", Thread.currentThread().getName());
                    Thread.sleep(1000);
                }finally {
                    lock.unlock();
                    System.out.printf("%s has released lock using lockInterruptibly.%n", Thread.currentThread().getName());
                }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName()+ " was interrupted while waiting for the lock.");
        }
    }
    //Main method
    public static void main(String[] args) {
        //Creating class object
        LockExample1 example1 = new LockExample1();

        //Demonstrating lock and unlock
        Thread thread1 = new Thread(example1::performTaskWithLock, "Thread 1");
        // Demonstrating tryLock()
        Thread thread2 = new Thread(example1::performTaskWithTryLock, "Thread 2");
        // Demonstrating timeout()
        Thread thread3 = new Thread(example1::performTaskWithTimeout, "Thread 3");
        // Demonstrating lockInterruptibly()
        Thread thread4 = new Thread(example1::performTaskWithInterruptibleLock, "Thread 4");

        //Starting thread
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
