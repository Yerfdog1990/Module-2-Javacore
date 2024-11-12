package StopThread;

public class Clock2 implements Runnable{
    public volatile boolean isRunning = true;
    //Method to stop thread
    void stop(){
        isRunning = false;
    }
    @Override
    public void run() {
        while(isRunning){
            try{
                System.out.println("Thread is running.......");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted.");
                    break;
                }
            }
            System.out.println("Thread has stopped.");
        }
    }
class StopThreadDemo{
    public static void main(String[] args) {
        //Create the task and run thread
        Clock2 clock2 = new Clock2();
        Thread thread = new Thread(clock2, "Stoppable thread.");

        //Start thread
        thread.start();

        //Let the thread run for 5 minutes
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted");
        }
        //Stop the running thread
        System.out.println("Requesting to stop thread.");
        clock2.stop();

        //Wait for the thread to finish
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted during join.");
        }
        System.out.println("Main thread completed.");
    }
}
