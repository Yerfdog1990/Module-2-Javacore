package AnonymousInnerClasses;

public interface OuterClass5 {
    void outerMethod();
    //Main method
    public static void main(String[] args) {
        // Create an anonymous inner class implementing Greeting
        OuterClass5 outerClass = new OuterClass5(){
            @Override
            public void outerMethod(){
                System.out.println("Hello from anonymous class");
            }
        };
        outerClass.outerMethod();
    }
}
