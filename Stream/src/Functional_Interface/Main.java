package Functional_Interface;

public class Main {
    public static void main(String[] args) {
        //1.Implementation using a Lambda Expression
        MyFunctionalInterface lambdaImplementation = message -> {
            System.out.println("Lambda says: " + message);
        };
        lambdaImplementation.execute("Hello from Lambda!");

        //2.Implementation using a Method Reference
        MyFunctionalInterface methodRefImplementation = System.out::println;
        methodRefImplementation.execute("Hello from method reference!");

        //3.Implementation using an Anonymous Class
        MyFunctionalInterface anonymousMethodImplementation = new MyFunctionalInterface() {
            @Override
            public void execute(String message) {
                System.out.println("Anonymous class says: " + message);
            }
        };
        anonymousMethodImplementation.execute("Hello from anonymous class!");
    }
}
