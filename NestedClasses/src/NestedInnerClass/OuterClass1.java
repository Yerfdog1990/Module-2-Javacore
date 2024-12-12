package NestedInnerClass;

public class OuterClass1 {
    public void outerMethod1(){
        System.out.println("Hello from outer class.");
    }
    class InnerClass1{
        public void innerMethod1(){
            System.out.println("Hello from inner class.");
        }
    }
    //Main method
    public static void main(String[] args) {
        OuterClass1 outerClass = new OuterClass1();
        outerClass.outerMethod1();
        OuterClass1.InnerClass1 innerClass = outerClass.new InnerClass1();
        innerClass.innerMethod1();

    }
}
