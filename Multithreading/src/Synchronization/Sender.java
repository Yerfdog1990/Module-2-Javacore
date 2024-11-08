package Synchronization;

public class Sender {
   //Method to send message
    void Send(String msg){
        System.out.println(msg+ " successfully sent.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(msg+ " successfully received.");
    }
}
class myThread extends Thread{
    String message;
    Sender sender;

    public myThread(Sender sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    @Override
    public void run() {
        // Only one thread can send a message at a time.
        synchronized (sender){
            //Synchronize sender object
            sender.Send(message);
        }
    }
}
//Driver class
class syncDemo{
    public static void main(String[] args) {
        Sender send = new Sender();
        myThread myThread1 = new myThread(send, "Message");
        myThread myThread2 = new myThread(send, "Money");

        //Setting priority in threads
        myThread1.setPriority(1);
        myThread1.setPriority(2);

        // Start two threads of ThreadedSend type
        myThread1.start();
        myThread2.start();

        // wait for threads to end
        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
