package ThreadClass;

public class ThreadConstructorsDemo {
    public static void main(String[] args) {
        // 1. Thread(): Allocates a new Thread object
        Thread thread1 = new Thread();
        System.out.println("Thread 1: " + thread1);

        // 2. Thread(Runnable target): Allocates a new Thread object with a Runnable target
        Runnable task = () -> System.out.println("Runnable task is running.");
        Thread thread2 = new Thread(task);
        thread2.start();  // Starting the thread to run the task
        System.out.println("Thread 2: " + thread2);

        // 3. Thread(Runnable target, String name): Allocates a new Thread object with a Runnable target and a name
        Thread thread3 = new Thread(task, "Named Runnable Thread");
        thread3.start();  // Starting the thread to run the task
        System.out.println("Thread 3: " + thread3);

        // 4. Thread(String name): Allocates a new Thread object with a specified name
        Thread thread4 = new Thread("Named Thread");
        System.out.println("Thread 4: " + thread4);

        // Creating a ThreadGroup for demonstration
        ThreadGroup group = new ThreadGroup("Demo Thread Group");

        // 5. Thread(ThreadGroup group, Runnable target): Allocates a new Thread object with a group and a Runnable target
        Thread thread5 = new Thread(group, task);
        thread5.start();  // Starting the thread to run the task
        System.out.println("Thread 5: " + thread5);

        // 6. Thread(ThreadGroup group, Runnable target, String name): Allocates a new Thread object with a group, a target, and a name
        Thread thread6 = new Thread(group, task, "Group Runnable Thread");
        thread6.start();  // Starting the thread to run the task
        System.out.println("Thread 6: " + thread6);

        // 7. Thread(ThreadGroup group, Runnable target, String name, long stackSize): Allocates a new Thread object with a group, a target, a name, and a stack size
        Thread thread7 = new Thread(group, task, "Thread with Stack Size", 1024);
        thread7.start();  // Starting the thread to run the task
        System.out.println("Thread 7: " + thread7);

        // 8. Thread(ThreadGroup group, String name): Allocates a new Thread object with a group and a name
        Thread thread8 = new Thread(group, "Group Named Thread");
        System.out.println("Thread 8: " + thread8);

        // Displaying details about the thread group
        System.out.println("Thread Group: " + group.getName());
    }
}