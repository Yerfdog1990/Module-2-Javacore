package Synchronization;

public class Counter {
    private int count = 0;

    //Synchronized Method (increment):
    // The entire method is synchronized to prevent multiple threads from executing it at the same time.
    public synchronized void increment(){
        count++;
        System.out.println(Thread.currentThread().getName()+ " incremented to " +count);
    }
    //Getter
    public int getCount() {
        return count;
    }
}
class synchronizedMethod implements Runnable{
    private final Counter counter;

    //Constructor 
    public synchronizedMethod(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter.increment();
        }
    }
    //Main method
    public static void main(String[] args) {
        Counter counterObject = new Counter();
        Thread thread1 = new Thread(new synchronizedMethod(counterObject), "Thread-1");
        Thread thread2 = new Thread(new synchronizedMethod(counterObject), "Thread-2");

        //Start thread
        thread1.start();
        thread2.start();

        //Set priority
        thread1.setPriority(1);
        thread2.setPriority(2);

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final count value: " +counterObject.getCount());
    }
}
