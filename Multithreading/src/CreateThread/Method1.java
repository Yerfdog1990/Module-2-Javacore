package CreateThread;

//Method 1: Creating a thread by extending Thread class
public class Method1 extends Thread{
    public void run() {
       try{
           System.out.println(Thread.currentThread().getName()+ " is running.");
       }catch (Exception e){
           System.out.println("Exception caught.");
       }
    }
}
class Main1{
    public static void main(String[] args) {
        int n = 8;
        for (int i = 0; i < n; i++) {
            Method1 object = new Method1();
            object.start();
        }
    }
}
