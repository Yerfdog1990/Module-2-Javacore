package CreateThread;

public class Method2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " is running.");
    }
}
class Main2{
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            Method2 object = new Method2();
            object.run();
        }
    }
}
