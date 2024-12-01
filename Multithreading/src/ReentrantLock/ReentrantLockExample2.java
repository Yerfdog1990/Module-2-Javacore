package ReentrantLock;

// Importing required classes
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

// Class representing a worker task
class Worker implements Runnable {
    String name; // Name of the task
    ReentrantLock re; // Shared lock object

    // Constructor to initialize the worker with a lock and a name
    public Worker(ReentrantLock rl, String n) {
        re = rl;
        name = n;
    }

    // The main task logic to run in the thread
    public void run() {
        boolean done = false; // To keep track if the task is finished

        while (!done) {
            // Try to acquire the outer lock
            boolean ans = re.tryLock();

            if (ans) { // If the lock is acquired successfully
                try {
                    // Log the time and task status
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println(
                            "Task name - " + name +
                                    " outer lock acquired at " + ft.format(d) +
                                    " Doing outer work");

                    Thread.sleep(1500); // Simulate some outer work

                    // Acquire inner lock
                    re.lock();
                    try {
                        d = new Date();
                        ft = new SimpleDateFormat("hh:mm:ss");
                        System.out.println(
                                "Task name - " + name +
                                        " inner lock acquired at " + ft.format(d) +
                                        " Doing inner work");
                        System.out.println(
                                "Lock Hold Count - " + re.getHoldCount());
                        Thread.sleep(1500); // Simulate some inner work
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        // Release the inner lock
                        System.out.println(
                                "Task name - " + name +
                                        " releasing inner lock");
                        re.unlock();
                    }

                    System.out.println("Lock Hold Count - " + re.getHoldCount());
                    System.out.println("Task name - " + name + " work done");

                    done = true; // Mark task as done
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // Release the outer lock
                    System.out.println(
                            "Task name - " + name +
                                    " releasing outer lock");
                    re.unlock();
                    System.out.println("Lock Hold Count - " + re.getHoldCount());
                }
            } else {
                // If the lock is not available, log and wait
                System.out.println("Task name - " + name + " waiting for lock");
                try {
                    Thread.sleep(1000); // Wait before retrying
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

// Main class to run the program
class Test {
    static final int MAX_T = 2; // Maximum number of threads in the pool

    public static void main(String[] args) {
        // Create a ReentrantLock object to be shared among tasks
        ReentrantLock rel = new ReentrantLock();

        // Create a thread pool with a fixed number of threads
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        // Create worker tasks
        Runnable w1 = new Worker(rel, "Job1");
        Runnable w2 = new Worker(rel, "Job2");
        Runnable w3 = new Worker(rel, "Job3");
        Runnable w4 = new Worker(rel, "Job4");

        // Execute tasks using the thread pool
        pool.execute(w1);
        pool.execute(w2);
        pool.execute(w3);
        pool.execute(w4);

        // Shutdown the thread pool after task execution
        pool.shutdown();
    }
}

