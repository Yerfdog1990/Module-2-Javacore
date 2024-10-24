package ClassReflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Animal {
    private String kingdomName;
    private String phylumName;
    private String className;

    public Animal() {
        this.className = className;
        this.phylumName = phylumName;
        this.kingdomName = kingdomName;
    }

    public String getClassName() {
        return className;
    }

    public String getPhylumName() {
        return phylumName;
    }

    public String getKingdomName() {
        return kingdomName;
    }
    public void printAnimalFeature(String animal1, String animal2, String kingdomName, String phylumName, String className){
        System.out.println("Common features in "+animal1+ " and " +animal2+ " are: Kingdom - " +kingdomName+ ", Phylum - " +phylumName+ ", Class - " +className);
    }

}
class Cat extends Animal {
    private String orderName;
    private String familyName;

    public Cat() {
        this.familyName = familyName;
        this.orderName = orderName;
    }

    @Override
    public void printAnimalFeature(String animal1, String animal2, String kingdomName, String phylumName, String className) {
        super.printAnimalFeature(animal1, animal2, kingdomName, phylumName, className);
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getOrderName() {
        return orderName;
    }
}
class Zebra extends Animal {
    private String orderName;
    private String familyName;

    public Zebra(String familyName, String orderName) {
        this.familyName = familyName;
        this.orderName = orderName;
    }

    @Override
    public void printAnimalFeature(String animal1, String animal2, String kingdomName, String phylumName, String className) {
        super.printAnimalFeature(animal1, animal2, kingdomName, phylumName, className);
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getOrderName() {
        return orderName;
    }
}
class Main{
    public static void main(String[] args) {
        try {
            Animal animal = new Animal();
            animal.printAnimalFeature("Cat", "Zebra", "Animalia", "Chordata", "Mammalia");
            Class animalClass = Animal.class;
            String className = animalClass.getName();
            System.out.println("Class name: " +className);
            String classPackage = String.valueOf(animalClass.getPackage());
            System.out.println("Class package: " +classPackage);
            Field[] fields1 = animalClass.getDeclaredFields();
            String declaredFields = Arrays.toString(fields1);
            System.out.println("Class fields: " +declaredFields);
            Field[] fields2 = animalClass.getFields();
            String classField = Arrays.toString(fields2);
            System.out.println("Class fields: " +classField);
            int classModifier = animalClass.getModifiers();// get the access modifier of the class
            String mod = Modifier.toString(classModifier);// convert the access modifier to string
            System.out.println("Class modifier: " +mod);


            Cat cat = new Cat();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


