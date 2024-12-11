package NestedInnerClass;

public class OuterClass {
    class InnerClass{
        public void displayMessage(){
            System.out.println("Hello from outer class.");
        }
        public void printMessage(){
            System.out.println("Hello from inner class.");
        }
    }
    //Main method
    public static void main(String[] args) {
       OuterClass.InnerClass obj = new OuterClass().new InnerClass();
        obj.printMessage();
        obj.displayMessage();
    }
}
