package Atomicity;
/*
Non-Atomic Version:
The counter++ operation is not atomic. It involves multiple steps (read, increment, write),
so two threads can interfere with each other, causing a race condition.
The final value of the counter may not be as expected.
 */
public class NonAtomicExample {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()-> increment());
        Thread thread2 = new Thread(()-> increment());

        //Start thread
        thread1.start();
        thread2.start();

        //Thread join
        thread1.join();
        thread2.join();

        // The counter might not be 20000 due to race conditions
        System.out.printf("Final counter value = %d.", counter);
    }
    private static void increment(){
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }
}
