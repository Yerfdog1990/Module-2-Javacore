package Thread.Sleep;

// Java Program for sleeping the main thread.
public class MainThread {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n; i++) {
            try {
                // it will sleep the main thread for 1 sec
                // ,each time the for loop runs
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+ " thread " +i+ " is running......");
        }
    }
}
