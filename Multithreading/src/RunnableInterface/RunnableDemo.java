package RunnableInterface;

public class RunnableDemo {
    public static void main(String[] args) {
        System.out.println("Main thread is " + Thread.currentThread().getName());
        Thread thread = new Thread(new RunnableDemo().new Demo());
        thread.start();
    }

    class Demo implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " thread running run method.");
        }
    }
}