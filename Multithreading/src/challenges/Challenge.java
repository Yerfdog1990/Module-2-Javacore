package challenges;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Challenge {
    private static final Lock lock = new ReentrantLock();
    public static void main(String[] args){
        int[] arr = {1, 22, 13, 4, 50, 16, 98, 37, 68, 9, 101};
        findSmallestNo(arr);
        findLargestNo(arr);
        findMiddleNo(arr);
    }
    public static void findSmallestNo(int[] arr){
        lock.lock();
        Arrays.sort(arr);
        int smallest = arr[0];
        try{
            for(int i = 1; i < arr.length; i++){
                if(arr[i] < smallest){
                    smallest = arr[i];
                    Thread.sleep(1000);
                }
            }
            System.out.println("Smallest number is: " + smallest);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted when fining smallest number.");
        }finally {
            lock.unlock();
            System.out.println("Lock released.");
        }
    }

    public static void findLargestNo(int[] arr){
        lock.lock();
        int largest = arr[0];
        try{
            for(int i = 1; i < arr.length; i++){
                if(arr[i] > largest){
                    largest = arr[i];
                    Thread.sleep(1000);
                }
            }
            System.out.println("Largest number is: " + largest);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted when finding largest number.");
        }finally {
            lock.unlock();
            System.out.println("Lock released.");
        }
    }
    public static void findMiddleNo(int[] arr){
        lock.lock();
        try{
            Arrays.sort(arr);
            int middle = arr[arr.length/2];
            System.out.println("Middle number is: " + middle);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted when finding middle number.");
        } finally {
            lock.unlock();
            System.out.println("Lock released.");
        }
    }
}
