package Synchronization;

public class StaticCounter {
    private static int count = 0;
    //Static Synchronization (staticSyncMethod):
    // Locks the class itself rather than an instance, used when the synchronized method is static.
    public static synchronized void staticIncrement(){
        System.out.println(Thread.currentThread().getName()+ " is incremented to " +count);
        count++;
    }
    //Getter
    public static int getCount() {
        return count;
    }
}
class StaticSynchronization implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            StaticCounter.staticIncrement();
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new StaticSynchronization(), "Thread-1");
        Thread thread2 = new Thread(new StaticSynchronization(), "Thread-2");

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
        System.out.println("Final count value: " +StaticCounter.getCount());
    }
}

