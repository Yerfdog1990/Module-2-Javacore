package ExecutorFramework;

import java.util.Scanner;
import java.util.concurrent.*;

public class Task implements Callable<String> {
    private String message;

    public Task(String message) {
        this.message = message;
    }
    @Override
    public String call() throws Exception {
        return "Hello " + message+ "!";
    }
}
class DriverClass{
    public static void main(String[] args) {
        try(Scanner name = new Scanner(System.in)){
            System.out.print("Enter name: ");
            String userInput = name.nextLine();
            Task task = new Task(userInput);
            ExecutorService executor = Executors.newCachedThreadPool();
            Future<String> future = executor.submit(task);
            try{
                System.out.println(future.get());
            }catch (InterruptedException | ExecutionException e){
                System.out.println("Error occurred while executing the submitted task");
                e.printStackTrace();
            }
            executor.shutdown();
        }
    }
}