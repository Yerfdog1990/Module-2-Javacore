/*
Rules for Method References
For a method reference to be valid:
1.Parameter List Match: The number and types of parameters in the interface method must match the number and types in the referenced method.
2.Return Type Compatibility: The return type of the referenced method must be compatible with the return type of the interface method.
 */
public interface Car {
    void model(String carModel, String carBody);
}
class Body{
    //Referenced method
    static void printModel(String model, String body){
        System.out.println("The car model is " +model+ ", while the body is " +body+ ".");
    }
    public static void main(String[] args) {
        //Referring to static method
        //You can refer to static method defined in the class.
        // Following is the syntax
        //ContainingClass::staticMethodName
        Car modelName = Body::printModel;
        //Calling interface method
        modelName.model("Mazda Grace", "Sedan");
    }
}
