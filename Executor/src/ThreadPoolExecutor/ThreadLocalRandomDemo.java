package ThreadPoolExecutor;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomDemo extends Thread{
    @Override
    public void run() {
        try{
            int bound = 100;
            int result = new Random().nextInt(bound);
            System.out.println("Thread #" +Thread.currentThread().getId()+ " generated " +result);
        }catch(Exception e){
            Thread.currentThread().interrupt();
        }
    }
    //Main method
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            ThreadLocalRandomDemo randomNumbers = new ThreadLocalRandomDemo();
            randomNumbers.start();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken = " +(endTime - startTime));
    }
}
