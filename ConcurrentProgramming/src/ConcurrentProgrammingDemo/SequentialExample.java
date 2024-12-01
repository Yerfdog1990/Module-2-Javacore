package ConcurrentProgrammingDemo;

public class SequentialExample {
    //main method
    public static void main(String[] args) {
        //Calling methods
        readFile();
        processData();
    //Without Concurrent Programming:
    //A program reads a file and processes its data sequentially. Both tasks block each other.
    }
    //Method to read file
    private static void readFile(){
        System.out.println("Read file .....");
        try {
            // Simulating time-consuming operation
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted.", Thread.currentThread().getName());
        }
    }
    //Method to process data file
    private static void processData(){
        System.out.println("Processing data .....");
        try {
            // Simulating time-consuming operation
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted.", Thread.currentThread().getName());
        }
    }
}
