package Finalize_CloseableInterface_TryWithResources;
/*
1. Using AutoCloseable Alone
When you implement the AutoCloseable (or Closeable) interface alone, you define how the resource should be closed, but you are responsible for calling the close() method manually.
This means that you need to remember to close the resource in every piece of code that uses it, typically in a finally block.
 */
public class MyResource1 implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Resource closed.");
    }
    public void useResource(){
        System.out.println("Using resources.");
    }

    public static void main(String[] args) {
        MyResource1 myResource1 = null;
        try{
            myResource1 = new MyResource1();
            myResource1.useResource();
        }finally {
            if(myResource1 != null){ //Calling the close() method manually.
                try{
                    myResource1.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
