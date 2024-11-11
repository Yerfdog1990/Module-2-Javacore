package Synchronization;

public class PrintTest {
    public void printThread(int n){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread " +n+ " is working........");
            }
        }
        System.out.println("------------------------------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Thread1 extends Thread{
    private PrintTest printTest1;

    public Thread1(PrintTest printTest) {
        this.printTest1 = printTest;
    }

    @Override
    public void run() {
        printTest1.printThread(1);
    }
}
class Thread2 extends Thread{
    private PrintTest printTest2;

    public Thread2(PrintTest printTest2) {
        this.printTest2 = printTest2;
    }

    @Override
    public void run() {
        printTest2.printThread(2);
    }
}
class SynchroTest{
    public static void main(String[] args) {
        //Create an instance of the PrintTest class
        PrintTest printTest = new PrintTest();
        //Create thread and passing the same object
        Thread1 thread1 = new Thread1(printTest);
        Thread2 thread2 = new Thread2(printTest);

        //Start thread
        thread1.start();
        thread2.start();
    }
}
