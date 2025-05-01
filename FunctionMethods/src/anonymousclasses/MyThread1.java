package anonymousclasses;
/*
Type 1: Anonymous Inner class that extends a class
We can have an anonymous inner class that extends a class.
For example, we know that we can create a thread by extending a Thread class.
Suppose we need an immediate thread but we don’t want to create a class that extends Thread class all the time.
With the help of this type of Anonymous Inner class, we can define a ready thread.
 */
// Java program to illustrate creating an immediate thread
// Using Anonymous Inner class that extends a Class

// Main class
class MyThread1 {

    // Main driver method
    public static void main(String[] args)
    {
        // Using Anonymous Inner class that extends a class
        // Here a Thread class
        Thread t = new Thread() {

            // run() method for the thread
            public void run()
            {
                // Print statement for child thread
                // execution
                System.out.println("Child Thread");
            }
        };

        // Starting the thread
        t.start();

        // Displaying main thread only for readability
        System.out.println("Main Thread");
    }
}
