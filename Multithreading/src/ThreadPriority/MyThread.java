package ThreadPriority;

public class MyThread extends Thread{
    public void run(){
        System.out.println("Inside run method.");
    }
//    If two threads have the same priority then we can’t expect which thread will execute first. It depends on the thread scheduler’s algorithm(Round-Robin, First Come First Serve, etc)
//    If we are using thread priority for thread scheduling then we should always keep in mind that the underlying platform should provide support for scheduling based on thread priority.
    public static void main(String[] args) {
        Thread.currentThread().setPriority(8);
        System.out.println("Main method priority - " +Thread.currentThread().getPriority());
        MyThread myThread = new MyThread();
        System.out.println("myThread priority - " +myThread.currentThread().getPriority());
    }
}
