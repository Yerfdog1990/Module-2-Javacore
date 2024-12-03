package Wait_Notify_NotifyAll;
/*
Definition of wait
In Java, wait() is a method of the Object class used for thread synchronization.
It causes the current thread to pause execution and release the lock it holds on an object, allowing other threads to acquire the lock and proceed.
The thread remains in a waiting state until:
    -Another thread calls notify() or notifyAll() on the same object.
    -The thread is interrupted.

Key Features of wait
1. Part of Object Class:
    -Defined in the java.lang.Object class.
    -Must be called inside a synchronized block or method; otherwise, it throws IllegalMonitorStateException.
2.Releases the Lock:
    -The thread calling wait() releases the lock on the object it is waiting for.
    -Other threads can acquire the lock and proceed.
3.Requires notify or notifyAll:
    -A thread in the waiting state can resume only when another thread calls notify() or notifyAll() on the same object.
4.Used in Inter-Thread Communication:
    -Enables threads to communicate by waiting for specific conditions to be met before continuing execution.
5.Overloaded Versions:
    -wait() – Waits indefinitely until notify or notifyAll is called.
    -wait(long timeout) – Waits for the specified time in milliseconds.
 */
public class WaitNotifyDemo {
    private static Object lock = new Object();
    private static boolean metCondition = false;
    public static void main(String[] args) {
        //Creating a waiting thread
        Thread waitingThread = new Thread(()->{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+ " is waiting for condition...");
                while (metCondition){
                    try {
                        //Call wait() method to allow thread go into waiting state
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName()+ " has been notified to resume execution.");
            }
        });
        //Create a notifying thread
        Thread notifyThread = new Thread(()->{
            synchronized (lock){
                System.out.println(Thread .currentThread().getName()+ " is setting condition and is notifying.");
                metCondition = true;
                lock.notify(); //Notify the waiting thread
            }
        });
        //Start waiting thread
        waitingThread.start();
        try {
            Thread.sleep(1500); // Ensure waitingThread starts first
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Starting notify thread
        notifyThread.start();
    }
}
