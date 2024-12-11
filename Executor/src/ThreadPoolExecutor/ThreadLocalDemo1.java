package ThreadPoolExecutor;

public class ThreadLocalDemo1 implements Runnable{
    private int counter;
    ThreadLocal<Integer> threadLocalCounters = ThreadLocal.withInitial(()->1);
    @Override
    public void run() {
        counter++;
        if(threadLocalCounters.get() != null){
            threadLocalCounters.set(threadLocalCounters.get() + 1);
        } else{
            if (threadLocalCounters.get() % 2 == 0) {
                threadLocalCounters.remove();
            } else{
                threadLocalCounters.set(0);
            }
        }
        printCounters();
    }
    public void printCounters(){
        System.out.println("Counters = " + counter);
        System.out.println("Thread Local counters = " +threadLocalCounters.get());
    }

    public static void main(String[] args) {
        //Create object of the class
        ThreadLocalDemo1 threadLocalDemo1 = new ThreadLocalDemo1();
        //Create threads
        Thread thread1 = new Thread(threadLocalDemo1);
        Thread thread2 = new Thread(threadLocalDemo1);
        Thread thread3 = new Thread(threadLocalDemo1);
        //Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
