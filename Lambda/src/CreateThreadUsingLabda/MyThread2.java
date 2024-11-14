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
        Thread obj3 = new Thread(myThread2);//Default priority - 5

        //Set thread priority
        obj1.setPriority(Thread.MAX_PRIORITY);//Priority - 10
        obj2.setPriority(Thread.MIN_PRIORITY);//Priority - 1
        //Start thread
        obj1.start();
        obj2.start();
        obj3.start();
    }
}
