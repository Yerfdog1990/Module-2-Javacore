package ThreadGroup;

public class ThreadGroupMethods {
    //Main method
    public static void main(String[] args) throws InterruptedException{
        //Create parent thread group
        ThreadGroup parentGroup = new ThreadGroup("ParentGroup");
        //Create parent thread group
        ThreadGroup childGroup = new ThreadGroup(parentGroup,"ChildGroup");
        //Create threads in teh child group
        Thread childThread1 = new Thread(childGroup, new myRunnable(),"ChildThread1");
        Thread childThread2 = new Thread(childGroup, new myRunnable(),"ChildThread2");
        Thread childThread3 = new Thread(childGroup, new myRunnable(),"ChildThread3");
        Thread childThread4 = new Thread(childGroup, new myRunnable(),"ChildThread4");

        //Start threads in child group
        childThread1.start();
        childThread2.start();
        childThread3.start();
        childThread4.start();

        //Display parent thread group name
        System.out.println("Parent thread group name: " +childGroup.getParent().getName());
        System.out.println("Child thread group name: " +childGroup.getName());

        //Check if teh group has daemon
        System.out.println("Is daemon? " +childGroup.isDaemon());
        //Set child thread group daemon property
        childGroup.setDaemon(true);
        System.out.println("Is daemon after setting? " + childGroup.isDaemon());
        //Display active threads in childGroup
        System.out.println("Active child thread counts: " +childGroup.activeCount());
        //Display active thread groups
        System.out.println("Active thread groups: " +childGroup.activeGroupCount());
        //Enumerate all threads in the group
        Thread[] threadList = new Thread[childGroup.activeCount()];
        System.out.println("Enumerated thread list: " +childGroup.enumerate(threadList));
        //Display thread name
        System.out.println("List of thread names:");
        for(Thread t : threadList){
            System.out.println(t.getName());
        }
        //Display the maximum priority of the group
        System.out.println("Maximum priority BEFORE setting: " +childGroup.getMaxPriority());
        //Set thread maximum priority
        childGroup.setMaxPriority(Thread.MAX_PRIORITY);
        System.out.println("Maximum priority AFTER setting: " +childGroup.getMaxPriority());
        //Interrupt all threads
        childGroup.interrupt();
        //Allow all threads to finish
        childThread1.join();
        childThread2.join();
        childThread3.join();
        childThread4.join();
    }
    static class myRunnable implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+ " was interrupted.");
            }
        }
    }
}
