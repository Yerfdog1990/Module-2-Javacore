package InterruptThread;
/*
The Thread.interrupt() method
What happens if the interrupt() method is called on a thread?

There are 2 possibilities:
    -If the object was in the waiting state, for example, due to the join or sleep methods, then the wait will be interrupted and the program will throw an InterruptedException.
    -If the thread was in a functioning state, then the boolean interrupted flag will be set on the object.
But we have to check the value of this flag on the object and correctly complete the work on our own! That's why the Thread class has the boolean isInterrupted() method.
 */
public class Clock extends Thread{
    public static void main(String[] args) throws InterruptedException{
        Clock clock = new Clock();
        clock.start();
        Thread.sleep(5000);
        clock.interrupt();
    }
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+ " was interrupted.");
                break;
            }
            System.out.println("Tick");
        }
    }
}
