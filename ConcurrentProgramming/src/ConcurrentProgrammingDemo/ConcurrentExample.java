package ConcurrentProgrammingDemo;
/*
Concurrent Programming: Definition
Concurrent programming is a style of programming where multiple tasks or processes are executed simultaneously or in an overlapping time frame. These tasks may run on separate processors (parallel execution) or share the same processor by switching between tasks (time-slicing).
The goal of concurrent programming is to achieve efficiency, responsiveness, and scalability in software by utilizing system resources effectively.

Key Characteristics of Concurrent Programming
1.Multiple Threads or Processes: Programs execute multiple independent tasks concurrently using threads, processes, or coroutines.
2.Shared Resources: Tasks often access shared resources like variables, memory, or files. Managing access to these shared resources is a key challenge.
3.Interleaving Execution: On a single processor, tasks may take turns executing (interleaving), creating an illusion of simultaneous execution.
4.Coordination: Mechanisms like locks, semaphores, or atomic operations coordinate tasks to avoid race conditions and deadlocks.
5.Scalability: Concurrent programs can take advantage of multi-core systems to execute tasks in true parallelism, improving performance.

Common Problems in Concurrent Programming
1.Race Conditions: Multiple threads access shared data simultaneously, leading to unpredictable outcomes.
2.Deadlocks: Two or more tasks block each other while waiting for resources.
3.Starvation: A thread waits indefinitely because higher-priority tasks keep it from executing.
4.Data Inconsistency: Improper synchronization can leave shared data in an invalid state.

Why Use Concurrent Programming?
1.Improved Performance: Leverages multi-core processors to perform tasks faster.
2.Responsiveness: Enhances the user experience by keeping applications responsive, even when performing time-consuming operations.
3.Efficiency: Allows multiple tasks (e.g., network calls, file I/O) to proceed simultaneously.
4.Real-Time Requirements: Supports real-time applications where tasks must be executed within strict time constraints.

Techniques for Writing Concurrent Programs
1.Threads: Lightweight processes within a program. Examples: Java Thread class or Runnable interface.
2.Thread Synchronization: Tools like synchronized, locks, semaphores, or atomic variables ensure safe access to shared resources.
3.Asynchronous Programming: Tasks run in the background without blocking the main thread. Examples: Promises, Futures, or async/await.
4.Parallelism: Tasks are split into subtasks and executed on multiple processors (true parallel execution).
 */
public class ConcurrentExample {
    //main method
    public static void main(String[] args) {
        //Creating threads
        Thread thread1 = new Thread(()-> readFile());
        Thread thread2 = new Thread(()-> processData());

        //Start threads
        thread1.start();
        thread2.start();
    }
    //Method to read file
    private static void readFile(){
        System.out.println("Read file .....");
        try {
            // Simulating time-consuming operation
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted.", Thread.currentThread().getName());
        }
    }
    //Method to process data file
    private static void processData(){
        System.out.println("Processing data .....");
        try {
            // Simulating time-consuming operation
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted.", Thread.currentThread().getName());
        }
    }
}
