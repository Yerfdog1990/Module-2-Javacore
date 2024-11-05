package ThreadClass;

import java.util.Map;

/*

 */
public class ThreadMethodsDemo {
    public static void main(String[] args) {
        // Creating a sample thread
        Thread thread = new Thread(() ->{
            try{
                // Simulating some work with sleep
                Thread.sleep(500);
                System.out.println("Thread execution completed.");
            }catch (InterruptedException e){
                System.err.println("Thread was interrupted.");
            }
        });
        // 1. start(): Starts the thread
        thread.start();
        // 2. activeCount(): Number of active threads
        System.out.println("Number of active thread count: " +Thread.activeCount());
        // 3. checkAccess(): Checks if current thread can modify the specified thread
        try{
            thread.checkAccess();
            System.out.println("Request to access the thread accepted");
        }catch (SecurityException e){
            System.out.println("Access denied");
        }
        // 4. clone(): Demonstrates that Thread cannot be cloned
        try{
            // Thread clonedThread = (Thread) thread.clone(); // Will not compile
            System.out.println("Sorry! Thread cannot be cloned.");
        }catch (Exception e){
            System.out.println("CloneNotSupportedException: " +e.getMessage());
        }
        // 5. currentThread(): Returns the current thread
        Thread currentThread = Thread.currentThread();
        System.out.println("Current thread: " +currentThread);
        // 6. dumpStack(): Prints the stack trace of the current thread
        Thread.dumpStack();
        // 7. enumerate(): Lists all active threads
        Thread[] threadArray = new Thread[Thread.activeCount()];
        Thread.enumerate(threadArray);
        System.out.println("Active threads in thread group.");
        for (Thread t : threadArray){
            System.out.println(t);
        }
        // 8. getAllStackTraces(): Returns stack traces of all threads
        Map<Thread, StackTraceElement[]> traces = Thread.getAllStackTraces();
        System.out.println("Stack traces of all live threads: " +traces);
        // 9. getContextClassLoader(): Gets the context class loader for this thread
        System.out.println("Context class loader: "+thread.getContextClassLoader());
        // 10. getDefaultUncaughtExceptionHandler(): Gets the default uncaught exception handler
        System.out.println("Default Uncaught Exception Handler: " +thread.getUncaughtExceptionHandler());
        // 11. getId(): Gets the thread's unique identifier
        System.out.println("Thread ID: " +thread.getId());
        // 12. getName(): Gets the name of the thread
        System.out.println("Thread name: " +thread.getName());
        // 13. getPriority(): Gets the thread's priority
        System.out.println("Get thread priority: " +thread.getPriority());
        // 14. getStackTrace(): Gets the stack trace of the thread
        StackTraceElement[] stackTrace = thread.getStackTrace();
        System.out.println("Stack trace: ");
        for(StackTraceElement elem : stackTrace){
            System.out.println(elem);
        }
        // 15. getState(): Gets the state of the thread
        System.out.println("Thread state: " +thread.getState());
        // 16. getThreadGroup(): Gets the thread group of the thread
        System.out.println("Thread group: " +thread.getThreadGroup());
        // 17. getUncaughtExceptionHandler(): Gets the handler for uncaught exceptions
        System.out.println("Uncaught Exception Handler: " +thread.getUncaughtExceptionHandler());
        // 18. holdsLock(): Checks if the current thread holds the monitor lock on the specified object
        Object lock = new Object();
        synchronized (lock){
            System.out.println("Holds lock: " +Thread.holdsLock(lock));
        }
        // 19. interrupt(): Interrupts the thread
        thread.interrupt();
        System.out.println("Thread interrupted.");
        // 20. interrupted(): Tests if the current thread has been interrupted
        System.out.println("Current thread interrupted: " +Thread.interrupted());
        // 21. isAlive(): Checks if the thread is alive
        System.out.println("Thread is alive: " +thread.isAlive());
        // 22. isDaemon(): Checks if the thread is a daemon thread
        System.out.println("Is Daemon: " + thread.isDaemon());

        // 23. isInterrupted(): Tests if the thread has been interrupted
        System.out.println("Thread is interrupted: " + thread.isInterrupted());

        // 24. join(): Waits for the thread to die
        try {
            thread.join();
            System.out.println("Thread has finished execution.");
        } catch (InterruptedException e) {
            System.err.println("Interrupted while waiting for thread to finish.");
        }

        // 25. setName(): Changes the name of the thread
        thread.setName("DemoThread");
        System.out.println("Thread new name: " + thread.getName());

        // 26. setDaemon(): Sets the thread as a daemon
        thread.setDaemon(true);
        System.out.println("Thread set to daemon.");

        // 27. setPriority(): Changes the thread's priority
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Thread new priority: " + thread.getPriority());

        // 28. setUncaughtExceptionHandler(): Sets the handler for uncaught exceptions
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.err.println("Uncaught exception in thread " + t.getName() + ": " + e.getMessage());
        });

        // 29. toString(): Returns a string representation of the thread
        System.out.println(thread.toString());

        // 30. yield(): Hints the scheduler to yield execution to another thread
        Thread.yield();
        System.out.println("Thread yielded.");

        // Inherited methods from Object
        // 31. equals(): Checks if the thread equals another thread
        System.out.println("equals(): " + thread.equals(currentThread));

        // 32. hashCode(): Gets the hash code of the thread
        System.out.println("hashCode(): " + thread.hashCode());

        // 33. getClass(): Gets the class of the thread
        System.out.println("getClass(): " + thread.getClass());

        // 34. wait(), notify(), and notifyAll(): Demonstrated in a synchronized block
        synchronized (lock) {
            try {
                lock.wait(100); // wait() method must be called within a synchronized block
                lock.notify();  // notify() method
                lock.notifyAll(); // notifyAll() method
            } catch (InterruptedException e) {
                System.err.println("Interrupted during wait.");
            }
        }
    }
}
