package NestedInnerClass;

public class OuterClass {
    public void displayMessage(){
        System.out.println("Hello from outer class.");
    }
    class InnerClass{
        public void printMessage(){
            System.out.println("Hello from inner class.");
        }
    }
    //Main method
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.displayMessage();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.printMessage();

    }
}
