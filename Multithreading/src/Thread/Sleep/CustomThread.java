package Thread.Sleep;

public class CustomThread extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName()+ "running...");
    }
    //Main method
    public static void main(String[] args) {
        CustomThread object = new CustomThread();
        int n = 5;
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread " +i+ " is running ...");
        }
    }
}
