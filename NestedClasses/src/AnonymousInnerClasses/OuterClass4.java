package AnonymousInnerClasses;

public class OuterClass4 {
    //Outer class method
    public void outerMethod(){
        System.out.println("Hello from outer (base) class");
    }
    //Main method
    public static void main(String[] args) {
        //Declaring an anonymous class extending the OuterClass4
        OuterClass4 outerClass = new OuterClass4(){
            @Override
            public void outerMethod(){
                System.out.println("Hello from anonymous class");
            }
        };
        outerClass.outerMethod();
        //Instantiate Outclass and call its method
        OuterClass4 outerClass2 = new OuterClass4();
        outerClass2.outerMethod();
    }
}
