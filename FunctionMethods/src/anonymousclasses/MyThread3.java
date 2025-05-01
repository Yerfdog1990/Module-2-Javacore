package anonymousclasses;
/*
Type 3: Anonymous Inner class that defines inside method/constructor argument
Anonymous inner classes in method/constructor arguments are often used in graphical user interface (GUI) applications.
To get you familiar with syntax lets have a look at the following program that creates a thread using this type of Anonymous Inner class.
 */
// Java program to illustrate defining a thread
// Using Anonymous Inner class that define inside argument

// Main class
class MyThread {
    // Main driver method
    public static void main(String[] args)
    {
        // Using Anonymous Inner class that define inside
        // argument
        // Here constructor argument
        Thread t = new Thread(new Runnable() {

            public void run()
            {
                System.out.println("Child Thread");
            }
        });

        t.start();

        System.out.println("Main Thread");
    }
}
