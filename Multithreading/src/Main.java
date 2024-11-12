
public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        Thread childThread1 = new Thread(thread);
        childThread1.start();
        Thread childThread2 = new Thread(thread);
        childThread2.run();
        Thread childThread3 = new Thread(thread);
        childThread3.run();
        Thread childThread4 = new Thread(thread);
        childThread4.run();
        Thread childThread5 = new Thread(thread);
        childThread5.run();
    }

}
class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is running ...........!");
    }
}