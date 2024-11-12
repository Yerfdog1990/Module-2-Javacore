package CreateLambdaExpression;

public interface School {
    void printName();
}
class Student implements School{
    @Override
    public void printName() {
        System.out.println("\nImplemented School interface:");
        System.out.println("My name is Godfrey.");
    }

    public static void main(String[] args) {
        Student myName1 = new Student();
        myName1.printName();
        System.out.println("\nUsed lambda expression:");
        School myName2 = ()-> System.out.println("My name is Godfrey.");
        myName2.printName();
    }
}


