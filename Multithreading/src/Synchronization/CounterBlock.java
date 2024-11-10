package Synchronization;

public class CounterBlock {
    private int count = 10;
    //Synchronized Block (decrement):
    // Only the critical section inside the method is synchronized, allowing more flexibility.
    public void decrement(){
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName()+ " decremented to " + count);
        }
    }

    public int getCount() {
        return count;
    }
}
class SynchronizedBlock implements Runnable{
    private CounterBlock counterBlock;

    public SynchronizedBlock(CounterBlock counterBlock) {
        this.counterBlock = counterBlock;
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counterBlock.decrement();
        }
    }

    public static void main(String[] args) {
        CounterBlock counterBlockObject = new CounterBlock();
        Thread thread1 = new Thread(new SynchronizedBlock(counterBlockObject), "Thread-1");
        Thread thread2 = new Thread(new SynchronizedBlock(counterBlockObject), "Thread-2");

        //Start thread
        thread1.start();
        thread2.start();

        //Join thread
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final count value: " +counterBlockObject.getCount());
    }
}