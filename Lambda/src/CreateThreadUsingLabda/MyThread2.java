package CreateThreadUsingLabda;

public class MyThread2 {
    public static void main(String[] args) {
        Runnable myThread2 = () -> {
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName()+ " is running .......");
            }
        };
        //Instantiate Thread class
        Thread obj1 = new Thread(myThread2);
        Thread obj2 = new Thread(myThread2);

        //Set thread priority
        obj1.setPriority(Thread.MAX_PRIORITY);
        obj2.setPriority(Thread.MIN_PRIORITY);
        //Start thread
        obj1.start();
        obj2.start();
    }
}
