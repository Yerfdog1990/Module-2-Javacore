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
        //Calling run() method using start() function
        for (int i = 0; i < n; i++) {
            Method1 object1 = new Method1();
            object1.start(); //Threads have different IDs
        }
        int m = 8;
        //Calling run() method using run() function
        for (int i = 0; i < m; i++) {
            Method1 object2 = new Method1();
            object2.run(); //Threads have the same IDs
        }
    }
}
