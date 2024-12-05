package ThreadPriority;

public class ThreadDemo extends Thread{
    public void run(){
        System.out.println("Inside the method.");
    }
    public static void main(String[] args) {
        ThreadDemo thread1 = new ThreadDemo();
        ThreadDemo thread2 = new ThreadDemo();
        ThreadDemo thread3 = new ThreadDemo();
        ThreadDemo thread4 = new ThreadDemo();

        //Display priority of each thread. Note, each thread is set to default priority - 5
        System.out.println("\nThreads with default priority assigned by JVM:");
        System.out.println("Priority of thread 1: " +thread1.getPriority());
        System.out.println("Priority of thread 2: " +thread2.getPriority());
        System.out.println("Priority of thread 3: " +thread3.getPriority());
        System.out.println("Priority of thread 4: " +thread4.getPriority());

       try{
           //Set the priority
           thread1.setPriority(MIN_PRIORITY); //Minimum priority - 1
           thread2.setPriority(2);
           thread3.setPriority(3);
           thread4.setPriority(MAX_PRIORITY); //Maximum priority - 10

           //Display priority of each thread after assigning priority
           System.out.println("\nThreads with priority assigned by the programmer:");
           System.out.println("Priority of thread 1: " +thread1.getPriority());
           System.out.println("Priority of thread 2: " +thread2.getPriority());
           System.out.println("Priority of thread 3: " +thread3.getPriority());
           System.out.println("Priority of thread 4: " +thread4.getPriority());

       }catch (IllegalArgumentException e){
           System.out.println("Sorry, illegal argument.");
       }
    }
}
