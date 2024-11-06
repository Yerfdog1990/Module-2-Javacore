package RunnableInterface;

public class RunnableDemo1 {
    public static void main(String[] args) {
        System.out.println("Main thread is " + Thread.currentThread().getName());
        Thread thread = new Thread(new RunnableDemo1().new Demo());
        thread.start();
    }

    class Demo implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " thread running run method.");
        }
    }
}