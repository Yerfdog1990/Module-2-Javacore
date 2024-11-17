/*
Syntax:
ClassName::new
Rules for Reference to a Constructor
    1.Interface Method Signature Match: The functional interface method's signature must match the constructor signature (i.e., the number and types of parameters).
    2.No Parameters in Constructor: If the functional interface's abstract method takes no parameters, you must refer to a no-argument constructor.
    3.Parameters in Constructor: If the functional interface's abstract method accepts parameters, you must refer to a constructor that accepts the same number and types of parameters.
    4.Return Type Compatibility: The functional interface's abstract method must return a type compatible with the class being instantiated.
 */
public interface School {
    void schoolProfile(String name, int established, int population);
}
class SchoolDetails{
    //Instances of the class
    String name;
    int established;
    int population;

    //Constructor
    public SchoolDetails(String name, int established, int population) {
        this.population = population;
        this.established = established;
        this.name = name;
        System.out.printf("The school is called %s, established in %d with a student population of %d.", name, established, population);
    }
    //Main method
    public static void main(String[] args) {
        //Reference to the constructor
        School printDetail = SchoolDetails::new;
        //Create an object of the
        printDetail.schoolProfile("Yerfdog International School", 2035,16);
    }
}
