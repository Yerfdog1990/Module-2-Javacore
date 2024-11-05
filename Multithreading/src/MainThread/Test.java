package MainThread;

public class Test extends Thread{
    //Main driver method
    public static void main(String[] args) {

        //Getting reference to the main method
        Thread t1 = Thread.currentThread();
        //Get name of the main thread
        System.out.println("Name of main thread: " +Thread.currentThread().getName());
        //Set name of the main thread
        t1.setName("Geek");
        System.out.println("Name assigned to main thread: " +Thread.currentThread().getName());
        //Access main thread default priority
        System.out.println("Main thread default priority: " +Thread.currentThread().getPriority());
        //Set priority of the main thread
        t1.setPriority(MAX_PRIORITY);
        System.out.println("Programmer assigned priority: " +Thread.currentThread().getPriority());
        System.out.println("Iterate over threads:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread " +i);
        }
        //Child thread created by main thread
        Test testThread = new Test();
        testThread.start();;
        // Start the second child thread (the Test thread)
        try{
            testThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        ChildThread ct = new ChildThread();
        ct.start();
        // Wait for the child thread to finish
        try{
            ct.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //Run method of thread
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Child thread " +i+ " inherited from Main thread.");
        }
        // Getting priority of child thread
        // which will be inherited from Main thread
        // as it is created by Main thread
        System.out.println("Priority of child thread inherited from Main thread: " +this.getPriority());
        //Set name of the main thread
        this.setPriority(8);
        //Display new priority of the child thread
        System.out.println("New priority of the child thread inherited from Main thread: " +this.getPriority());
    }
}
// Helper class extending Thread class
// Child Thread class
class ChildThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {

            // Print statement whenever child thread is called
            System.out.println("Child thread " +i+ " created as a helper class.");
        }
    }
}
