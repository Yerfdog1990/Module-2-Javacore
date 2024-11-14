package LambdaExpressionVariableCapturing;

public interface MyInterface {
    void myFunction();
}
class MyClass{
    int data = 10;

    public static void main(String[] args) {
        //Creating object of this class
        MyClass myClass = new MyClass();
        //Creating object of the interface
        MyInterface myInterface = () ->{
            System.out.println("Data before modification: " +myClass.data);
            myClass.data++;
            System.out.println("Data after modification: " +myClass.data);
        };
        //Using lambda expression
        myInterface.myFunction();
        //Modify instance of variable
        myClass.data += 200;
        System.out.println("Final data: " +myClass.data);
    }
}
