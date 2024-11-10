package Synchronization;
//Cooperation (Inter-thread communication):
//Uses wait(), notify(), and notifyAll() methods to allow threads to communicate with each other.
public class Message {
    private String message;
    private boolean isEmpty = true;

    public synchronized void produceMessage(String msg){
        while (!isEmpty){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.message = msg;
        isEmpty = false;
        System.out.println("Produced: " +msg);
        notify();
    }
    public synchronized void consumeMessage(){
        while(isEmpty){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Consumed: " +message);
        isEmpty = true;
        notify();
    }
}
class Producer implements Runnable{
    private Message message;

    public Producer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {"Hello", "Java", "Multithreading", "End"};
        for(String str : messages){
            message.produceMessage(str);
        }
    }
}
class Consumer implements Runnable{
    private Message message;

    public Consumer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            message.consumeMessage();
        }
    }
}
class InterThreadCommunicationDemo{
    public static void main(String[] args) {
        Message message = new Message();
        Thread producerThread = new Thread(new Producer(message), "Producer");
        Thread consumerThread = new Thread(new Consumer(message), "Consumer");

        //Start the thread
        producerThread.start();
        consumerThread.start();

        //Join threads
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Inter-thread communication between producer and consumer thread successfully completed.");
    }
}
