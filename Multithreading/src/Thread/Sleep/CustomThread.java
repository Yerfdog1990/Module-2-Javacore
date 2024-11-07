package Thread.Sleep;

// Java Program for sleeping the custom thread.
public class CustomThread extends Thread{
    public void run() {
        System.out.println(Thread.currentThread().getName());//Thread 0
       try{
           for (int i = 0; i < 5; i++) {
               // it will sleep the main thread for 1 sec
               // ,each time the for loop runs
               Thread.sleep(5000);//Throw IllegalArgumentException if time is negative
               // This Thread.sleep() method will sleep the
               // thread 0.
               // printing the value of the variable
               System.out.println("Custom thread " +i+ " is running...");
           }
       }catch (InterruptedException e) {
        throw new RuntimeException(e);
        }
    }
    //Main method
    public static void main(String[] args) {
        CustomThread object = new CustomThread();
        object.start();
    }
}
