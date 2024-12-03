package Deadlock;

public class DeadlockExample2 {
    public static void main(String[] args) {
        //Create the shared resource objects
        Resource resource1 = new Resource("Resource1");
        Resource resource2 = new Resource("Resource2");

        //Create thread to run the first resource then second resource.
        Thread thread1 = new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread().getName()+ " locked " +resource1.getName());
                try {
                    // Simulate some work with resource1
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (resource2){
                    System.out.println(Thread.currentThread().getName()+ " locked " +resource2.getName());
                }
            }
        });
        //Create thread to run the second resource then first resource
        Thread thread2 = new Thread(()->{
            synchronized (resource2){
                System.out.println(Thread.currentThread().getName()+ " locked " +resource2.getName());
                try {
                    //Simulate some with resource 2
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (resource1){
                    System.out.println(Thread.currentThread().getName()+ " locked " +resource1.getName());
                }
            }
        });
        //Start both threads
        thread1.start();
        thread2.start();
    }
}
class Resource{
    private String name;

    //Constructor
    public Resource(String name) {
        this.name = name;
    }

    //Getter
    public String getName() {
        return name;
    }

}
