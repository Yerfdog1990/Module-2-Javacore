package MethodLocalInnerClasses;
/*
Inner class can be declared within a method of an outer class.
Method Local inner classes can’t use a local variable of the outer method until that local variable is not declared as final.
 */
public class OuterClass2 {
    //Outer class method.
    public void outerMethod2(){
        System.out.println("Hello from outer class.");
        //Inner class declared within method of the outer class.
        class InnerClass2 {
            void innerMethod2(){
                System.out.println("Hello from inner class.");
            }
        }
        // Creating object of inner class
        InnerClass2 innerClass2 = new InnerClass2();
        // Calling over method defined inside it
        innerClass2.innerMethod2();
    }
    //Main method
    public static void main(String[] args) {
        // Creating object of outer class inside main() method
        OuterClass2 outerClass2 = new OuterClass2();
        // Calling outer method inside the main() method
        outerClass2.outerMethod2();

    }
}
