package ThreadPriority;

public class NonVolatile {
    private static boolean flag = true;

    //Main method
    public static void main(String[] args) {
        Thread monitorThread = new Thread(()->{
            while(flag){
            }
            System.out.println("Monitor thread has detected flag change!");
        });
        monitorThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main flag is setting flag to false.");
        flag = false;

        /*
        Explanation
        The flag variable is not marked as volatile, so the monitor thread might use a cached value of flag instead of checking the shared memory.
        The main thread updates flag to false, but the monitor thread might not detect this change and could continue looping indefinitely.
         */
    }
}
