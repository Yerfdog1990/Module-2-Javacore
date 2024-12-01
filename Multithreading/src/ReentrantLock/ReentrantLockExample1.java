package ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/*
1.ReentrantLock: Allows a thread to acquire the same lock multiple times.
2.lock(): Call to the lock() method increments the hold count by 1 and gives the lock to the thread if the shared resource is initially free.
3.unlock(): Call to the unlock() method decrements the hold count by 1. When this count reaches zero, the resource is released.
4.tryLock(): If the resource is not held by any other thread, then call to tryLock() returns true and the hold count is incremented by one. If the resource is not free, then the method returns false, and the thread is not blocked, but exits.
5.tryLock(long timeout, TimeUnit unit): As per the method, the thread waits for a certain time period as defined by arguments of the method to acquire the lock on the resource before exiting.
6.lockInterruptibly(): This method acquires the lock if the resource is free while allowing for the thread to be interrupted by some other thread while acquiring the resource. It means that if the current thread is waiting for the lock but some other thread requests the lock, then the current thread will be interrupted and return immediately without acquiring the lock.
7.getHoldCount(): This method returns the count of the number of locks held on the resource.
8.isHeldByCurrentThread(): This method returns true if the lock on the resource is held by the current thread.
9.hasQueuedThread(): This Method Queries whether the given thread is waiting to acquire this lock.
10.isLocked(): Queries if this lock is held by any thread.
11.newCondition(): Returns a Condition instance for use with this Lock instance.
 */
public class ReentrantLockExample1 {
    // Shared ReentrantLock object
    private static final ReentrantLock rlock = new ReentrantLock();
    //Main method
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Worker(), "Thread-1");
        Thread thread2 = new Thread(new Worker(), "Thread-2");

        //Start thread
        thread1.start();
        thread2.start();
    }
    static class Worker implements Runnable {
        @Override
        public void run() {
            try {
                //Thread attempting to acquire lock
                System.out.printf("%s is attempting to acquire lock.%n", Thread.currentThread().getName());
                //Thread has acquired lock using lockInterruptibly
                rlock.lockInterruptibly();
                System.out.printf("%s has acquired lock using lockInterruptibly.%n", Thread.currentThread().getName());
                //Incrementing hold count with lock()
                rlock.lock();
                System.out.printf("%s incremented lock. Hold count = %d.%n", Thread.currentThread().getName(), rlock.getHoldCount());
                // Checking if the lock is held by the current thread
                if (rlock.isHeldByCurrentThread()) {
                    System.out.printf("%s holds the lock.", Thread.currentThread().getName());
                }
                // Checking if another thread is waiting for the lock
                System.out.printf("%s is waiting for the lock: %b%n", Thread.currentThread().getName(), rlock.hasQueuedThread(Thread.currentThread()));
                //Simulate work
                Thread.sleep(2000);
                // Trying to acquire lock using tryLock with timeout
                boolean acquired = rlock.tryLock(2, TimeUnit.SECONDS);
                if(acquired){
                    System.out.printf("%s acquired lock using tryLock with timeout. Hold count: %d.%n", Thread.currentThread().getName(), rlock.getHoldCount());
                }else{
                    System.out.printf("%s could not acquire lock using tryLock with timeout.%n", Thread.currentThread().getName());
                }
                // Using newCondition()
                System.out.printf("Condition instance created using newCondition(): %s%n", rlock.newCondition());
                // Check if the lock is held by any thread
                System.out.printf("Is there any lock held by thread? %s%n", rlock.isLocked());
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted");
                // Unlock all acquired locks
            }finally {
                while(rlock.getHoldCount() > 0){
                    rlock.unlock();
                    System.out.printf("%s has released lock. Hold count = %d.%n", Thread.currentThread().getName(), rlock.getHoldCount());
                }
            }
        }
    }
}
