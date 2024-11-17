/*
Syntax:
containingObject::instanceMethodName

Rules for Reference to an Instance Method:
    1.Interface Method Signature Match: The method signature in the functional interface must match the instance method's signature.
    2.Object Context: You must have an instance of the class to use this method reference (containingObject).
    3.Parameter Passing: When calling the functional interface method, its parameters are passed to the referenced instance method.
    4.Return Type Compatibility: The return type of the instance method must be compatible with the return type defined in the functional interface.
 */
//Functional interface
public interface Student {
    void studentProfile(String name, int form, int age);
}
class StudentDetails{
    //Instance method
    void printDetails(String name, int form, int age){
        System.out.printf("The student is called %s from year %d. She is %d years old.", name, form, age);
    }
    //Main class
    public static void main(String[] args) {
        //Create class object
        StudentDetails details = new StudentDetails();
        //Referring to instance method
        Student student = details::printDetails;
        //Calling interface method
        student.studentProfile("Janet", 13, 17);
    }
}
