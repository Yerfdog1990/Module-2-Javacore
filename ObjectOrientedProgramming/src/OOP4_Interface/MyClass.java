package OOP4_Interface;

import java.io.*;

public class MyClass extends InputStream{
    private String data = "Hello world! Welcome to learning Inputstream interface";
    private int currentIndex = 0;

    @Override
    public int read() throws IOException{
        if(currentIndex >= data.length()){
            return -1;
        }else {
            return data.charAt(currentIndex++);
        }
    }
    @Override
    public int available() throws IOException{
        return data.length() - currentIndex;
    }

    public static void main(String[] args) {
        MyClass myClassObject = new MyClass();
        // Writing a MyClass object to a file using a relative path
        try {
            File directory = new File("files");
            if(!directory.exists()){
                directory.mkdir();// Create the directory if it doesn't exist
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Files folder successfully created.");
        //Write a MyClass object to a file
        try (OutputStream outputStream = new FileOutputStream("files/output.txt")) {

            while(myClassObject.available() > 0){
                int data = myClassObject.read();
                outputStream.write(data);
            }
            System.out.println("Data written successfully.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
