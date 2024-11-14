package CreateThreadUsingLabda;

public class MyThread {
    public static void main(String[] args) {
        // Creating Lambda expression for run() method in
        // functional interface "Runnable"
        Runnable thread = () ->{
            // Used to set custom name to the current thread
            Thread.currentThread().setName("MyThread");
            System.out.println(Thread.currentThread().getName()+ " is running ......");
        };
        // Instantiating Thread class by passing Runnable
        // reference to Thread constructor
        Thread obj = new Thread(thread);
        // Starting thread
        obj.start();
    }
}
