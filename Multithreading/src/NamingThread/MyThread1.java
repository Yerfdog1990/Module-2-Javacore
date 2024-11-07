package NamingThread;

public class MyThread1 extends Thread{
    private String name;

    //Sets the thread name during creation
    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " is running...");
    }
    //Main method
    public static void main(String[] args) {
        //Creating thread
        MyThread1 myThread1 = new MyThread1("Geek1");
        MyThread1 myThread2 = new MyThread1("Geek2");

        //Getting the name of the thread above.
        System.out.println("Thread 1: " +myThread1.getName());
        System.out.println("Thread 2: " +myThread2.getName());

        //Staring threads using start() method
        myThread1.start();
        myThread2.start();

    }
}
