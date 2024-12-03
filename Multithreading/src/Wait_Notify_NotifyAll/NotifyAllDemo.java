package Wait_Notify_NotifyAll;
/*
Definition of notify and notifyAll
notify(): Wakes up one thread that is waiting on the monitor of the object. The awakened thread will proceed once it regains the lock on the object.
notifyAll(): Wakes up all threads waiting on the monitor of the object. Only one thread will execute at a time, as each needs to reacquire the lock before proceeding.
Key Features
1.Part of Object Class:
    -Defined in the java.lang.Object class.
    -Must be used inside a synchronized block or method.
2.Does Not Release Lock Immediately:
    -The thread calling notify or notifyAll does not release the lock immediately; it holds the lock until the synchronized block/method finishes.
3.Wakes Waiting Threads:
    -notify() wakes only one waiting thread.
    -notifyAll() wakes all waiting threads, but they proceed one by one as the lock is reacquired.
4.Works with wait:
    -Threads in the waiting state can resume only when notify or notifyAll is called on the same object they are waiting for.
 */
public class NotifyAllDemo {
    private static Object lock = new Object();
    private static boolean metCondition = false;
    //Main method
    public static void main(String[] args) {
        //Create waiting threads
        Thread waitingThread1 = new Thread(()->waitForCondition());
        Thread waitingThread2 = new Thread(()->waitForCondition());

        //Create notifying thread
        Thread notifyingThread = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+ " is setting condition and notifying waiting thread to resume execution.");
            synchronized (lock){
                metCondition = true; // Wakes up one waiting thread
                lock.notifyAll();
            }
        });
        try {
            //Starting waiting threads
            waitingThread1.start();
            waitingThread2.start();
            // Ensure waiting threads start first
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Starting notifying thread
        notifyingThread.start();
    }
    static void waitForCondition(){
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+ " is waiting for condition....");
            while (!metCondition){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName()+ " has been notified and ready to execute.");
        }
    }
}
