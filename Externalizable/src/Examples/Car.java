package Examples;

import java.io.*;

public class Car implements Externalizable {
    private String model;
    private  int YoM;
    private int mileage;

    //Non-parameterized constructor
    public Car() {
        System.out.println("\nDefault constructor called.");
    }
    //Parameterized constructor
    public Car(String model, int yoM, int mileage) {
        this.model = model;
        YoM = yoM;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return ("\nModel: " +model+
                "\nYoM: " +YoM+
                "\nMileage: " +mileage);
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //out.writeObject(model);
        out.writeInt(YoM);
        out.writeInt(mileage);
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //model = (String)in.readObject();
        YoM = in.readInt();
        mileage = in.readInt();
    }
    //Getters
    public int getMileage() {
        return mileage;
    }
    public int getYoM() {
        return YoM;
    }
    public String getModel() {
        return model;
    }
}
class ExternalizableExample1{
    //Main method
    public static void main(String[] args) {
        Car car1 = new Car("Mercedes Benz", 2024, 15000);
        Car car2 = null;
        //Serialize the car
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("car.ser"));
            out.writeObject(car1);
            out.flush();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //Deserialize the car
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("car.ser"));
            car2 = (Car) in.readObject();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("\nSerialized car fields: " +car1);
        System.out.println("\nDeserialized car fields: " +car2);
    }
}
