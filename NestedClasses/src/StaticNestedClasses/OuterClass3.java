package StaticNestedClasses;

public class OuterClass3 {
    public static void outerMethod(){
        System.out.println("Hello from outer class");
    }
    public static class InnerClass3 {
        public static void innerMethod(){
            System.out.println("Hello from inner class");
            outerMethod();
        }
    }
    //Main method
    public static void main(String[] args) {
        OuterClass3.InnerClass3.innerMethod();
    }
}
