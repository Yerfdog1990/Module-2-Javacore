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
public class NotifyDemo {

}
