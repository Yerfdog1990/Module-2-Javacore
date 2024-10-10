package Super_Extend_List;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator <T extends Volume>{
    T volume;

    public T getVolume() {
        return volume;
    }

    public void setVolume(T volume) {
        this.volume = volume;
    }
    public double getVolumeOfCylinder(){
        return this.volume.findCylinderVolume();
    }
    public double getVolumeOfCone(){
        return this.volume.findConeVolume();
    }
    public double getVolumeOfSphere(){
        return this.volume.findSphereVolume();
    }
    public double getVolumeOfHemisphere(){
        return this.volume.findHemisphereVolume();
    }
}
class Volume{
    private double radius;
    private double height;
    private final double pi = Math.PI;

    public Volume(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    public double getPi() {
        return pi;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double findCylinderVolume(){
        double volume = getPi() * Math.pow(radius, 2)*height;
        return volume;
    }
    public double findConeVolume(){
        double volume = 1.0/3*(getPi() * Math.pow(radius, 2)*height);
        return volume;
    }
    public double findSphereVolume(){
        double volume = 4.0/3*getPi() * Math.pow(radius, 3);
        return volume;
    }
    public double findHemisphereVolume(){
        double volume = 2.0/3*getPi() * Math.pow(radius, 3);
        return volume;
    }
}
class MainCalculator {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter radius: ");
                double radius = userInput.nextDouble();
                System.out.print("Enter height: ");
                double height = userInput.nextDouble();

                Calculator<Volume> volumeCalculator = new Calculator<>();
                volumeCalculator.setVolume(new Volume(height, radius));
                System.out.printf("Volume of cylinder = %.2fcm\u00B3.\n", volumeCalculator.getVolumeOfCylinder());
                System.out.printf("Volume of cone = %.2fcm\u00B3.\n", volumeCalculator.getVolumeOfCone());
                System.out.printf("Volume of sphere = %.2fcm\u00B3.\n", volumeCalculator.getVolumeOfSphere());
                System.out.printf("Volume of hemisphere = %.2fcm\u00B3.\n", volumeCalculator.getVolumeOfHemisphere());

                break;  // Exit loop after valid input and successful calculation
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                userInput.next();  // Clear the invalid input
            }
        }
        userInput.close();  // Close the scanner after the loop
    }
}
