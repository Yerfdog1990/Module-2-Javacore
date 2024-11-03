package ThreadLifeCycle;
/*
Lifecycle and States of a Thread in Java
A thread in Java at any point of time exists in any one of the following states. A thread lies only in one of the shown states at any instant:
1.New Thread: When a new thread is created, it is in the new state. The thread has not yet started to run when the thread is in this state. When a thread lies in the new state, its code is yet to be run and hasn’t started to execute.
2.Runnable State: A thread that is ready to run is moved to a runnable state. In this state, a thread might actually be running or it might be ready to run at any instant of time. It is the responsibility of the thread scheduler to give the thread, time to run. A multi-threaded program allocates a fixed amount of time to each individual thread. Each and every thread runs for a short while and then pauses and relinquishes the CPU to another thread so that other threads can get a chance to run. When this happens, all such threads that are ready to run, waiting for the CPU and the currently running thread lie in a runnable state.
3.Blocked state: The thread will be in blocked state when it is trying to acquire a lock but currently the lock is acquired by the other thread. The thread will move from the blocked state to runnable state when it acquires the lock.
4.Waiting state: The thread will be in waiting state when it calls wait() method or join() method. It will move to the runnable state when other thread will notify or that thread will be terminated.
5.Timed Waiting: A thread lies in a timed waiting state when it calls a method with a time-out parameter. A thread lies in this state until the timeout is completed or until a notification is received. For example, when a thread calls sleep or a conditional wait, it is moved to a timed waiting state.
6.Terminated State: A thread terminates because of either of the following reasons:
    -Because it exits normally. This happens when the code of the thread has been entirely executed by the program.
    -Because there occurred some unusual erroneous event, like a segmentation fault or an unhandled exception.
 */
// Main class to demonstrate thread states
public class ThreadStates {
    public static void main(String[] args) {
        // Creating a new Thread.
        Thread thread = new Thread(new ExampleRunnable());
        // Thread is in NEW state
        System.out.println("State after thread creation - " +thread.getState());
        //Start the thread
        thread.start();
        // Thread is in RUNNABLE state
        System.out.println("State after calling start - " +thread.getState());

        try{
            // Make the main thread sleep to give the ExampleRunnable thread a chance to run
            Thread.sleep(100);
            // Sending signal to the waiting thread using notify()
            synchronized (ExampleRunnable.lock){
                System.out.println("The main thread is sending a notification ........" +thread.getState());
                ExampleRunnable.lock.notify();
            }
            // Waiting for the thread to die
            thread.join();
            // Thread is in TERMINATED state after completion
            System.out.println("State after thread termination - " +thread.getState());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
// Runnable class that contains synchronized and waiting methods
class ExampleRunnable implements Runnable{
    static final Object lock = new Object();
    @Override
    public void run() {
        // Runnable state: Thread is running
        System.out.println("The thread is running and in state - " +Thread.currentThread().getState());

        // Synchronized block to demonstrate BLOCKED state
        synchronized (lock){
            try{
                // Timed waiting state using Thread.sleep
                System.out.println("Thread is sleeping.");
                Thread.sleep(1000); // TIMED_WAITING state
                System.out.println("Thread woke up and in state - " +Thread.currentThread().getState());

                // Waiting state using Object.wait
                System.out.println("Thread is waiting for signal ......");
                lock.wait();
                lock.notify();
                System.out.println("Thread got a signal and is now in state - " +Thread.currentThread().getState());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            // Thread completes and enters TERMINATED state
            System.out.println("Thread is about to terminate.");
        }
    }
}
