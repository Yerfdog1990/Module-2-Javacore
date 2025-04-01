package ExecutorFramework;


import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorsDemo {
    public static void main(String[] args){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = ()-> System.out.println("Task executed at " +System.currentTimeMillis());

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for(int i=0;i<10;i++){
            final int index = i;
            executor.execute(()->{
                list.add("Task "+index);
                System.out.println(list);
            });
        }
        executor.shutdown();
    }
}
