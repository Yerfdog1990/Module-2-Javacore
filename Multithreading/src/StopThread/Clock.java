package StopThread;

public class Clock implements Runnable{
    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(1000);
                System.out.println("Tick");
                if(!ThreadManager.isClockRun){
                    System.out.println("Clocked stopped.");
                    return;
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted");
            }
            return;
        }
    }
}
class ThreadManager{
    public static boolean isClockRun = true;
    public static void main(String[] args) {
        Clock clockThread = new Clock();
        Thread obj = new Thread(clockThread);
        obj.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted.");
        }
        isClockRun = false;
        System.out.println("Stopping the clock ........");
    }
}
