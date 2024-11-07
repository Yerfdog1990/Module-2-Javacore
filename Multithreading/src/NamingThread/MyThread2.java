package NamingThread;

public class MyThread2 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread()+ " is running.");
    }
    //Main method
    public static void main(String[] args) {
        //Creating threads
        MyThread2 myThread21 = new MyThread2();
        MyThread2 myThread22 = new MyThread2();

        //Getting the current thread name
        System.out.println("Old thread 1 name: " +myThread21.getName());
        System.out.println("Old thread 2 name: " +myThread22.getName());

        //Set the thread name after creation
        myThread21.setName("Geek 1");
        myThread22.setName("Geek 2");

        //Getting the new name of the set
        System.out.println("New thread 1 name: " +myThread21.getName());
        System.out.println("New thread 2 name: " +myThread22.getName());

        //Starting threads using start() method
        myThread21.start();
        myThread22.start();
    }
}
