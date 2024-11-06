package RunnableInterface;

import java.io.FileNotFoundException;

public class RunnableDemo2 {
    public static void main(String[] args) {
        System.out.println("Name of the thread " +Thread.currentThread().getName());
        Demo2 demo2 = new Demo2();
        demo2.run();
    }
    static class Demo2 implements Runnable{
        @Override
        public void run() {
            System.out.println("Running the run() method.");
            try {
                throw new FileNotFoundException();
            }
            catch (FileNotFoundException e) {
                System.out.println("Must catch here!");
                e.printStackTrace();
            }

            int r = 1 / 0;
        }
    }
}
