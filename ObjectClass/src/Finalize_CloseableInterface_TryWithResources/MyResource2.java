package Finalize_CloseableInterface_TryWithResources;
/*
Using AutoCloseable and Try-with-Resources Together
This is the best practice. You implement the AutoCloseable interface to define how the resource should be closed, and you use try-with-resources to ensure automatic and safe cleanup without needing to explicitly manage the closure.
Note:
    1.You can't use try-with-resources alone without a resource that implements AutoCloseable or Closeable.
    2.The main advantage of the try-with-resources statement is that it automatically calls close() for any resource declared in the try block.
    3.However, for try-with-resources to work, the resource must implement AutoCloseable (or Closeable), so you will always need both in practice.
 */
public class MyResource2 implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Resource closed.");
    }
    public void useResource(){
        System.out.println("Using resources.");
    }

    public static void main(String[] args) {
        //No need to manually call close() method.
        try (MyResource2 myResource2 = new MyResource2()){
            myResource2.useResource();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
