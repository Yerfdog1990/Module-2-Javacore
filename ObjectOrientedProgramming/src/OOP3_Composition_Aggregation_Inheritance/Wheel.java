package OOP3_Composition_Aggregation_Inheritance;
/*
Composition
Description: A strong form of aggregation where the contained objects cannot exist independently of the parent object.
 */
public class Wheel {
    String type;

    public Wheel(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
class Car{
    private Wheel wheel;

    public Car(Wheel wheel) {
        this.wheel = wheel;
    }

    public Wheel getWheel() {
        return wheel;
    }
    public void displayInfo(){
        System.out.println("The car has an "+wheel.getType()+ " wheel.");
    }
}

class CompositionDemo{
    public static void main(String[] args) {
        Wheel alloyWheel = new Wheel("alloy");
        Car car = new Car(alloyWheel);
        car.displayInfo();
    }
}
