package ReflectionOfClass;

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
    public String printAnimalFeature(String animal, String kingdomName, String phylumName, String className){
        String animalFeature = "features of "+animal+ " are: \n1.Kingdom - " +kingdomName+ ", \n2.Phylum - " +phylumName+ ", \n3.Class - " +className;
        return animalFeature;
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
    public String printAnimalFeature(String animal, String kingdomName, String phylumName, String className) {
        return super.printAnimalFeature(animal, kingdomName, phylumName, className);
    }

    public String printCatFeatures(String familyName, String orderName){
        String fromAnimalClass = super.printAnimalFeature("Cat", "Animalia", "Chordata", "Mammalia");
        String fromCatclass = "\n4.Family - " +familyName+ " \n5.Order - " +orderName;
        return fromAnimalClass + fromCatclass;
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

    public Zebra() {
        this.familyName = familyName;
        this.orderName = orderName;
    }

    @Override
    public String printAnimalFeature(String animal, String kingdomName, String phylumName, String className) {
        return super.printAnimalFeature(animal, kingdomName, phylumName, className);
    }

    public String printZebraFeatures(String familyName, String orderName){
        String fromAnimalClass = super.printAnimalFeature("Zebra", "Animalia", "Chordata", "Mammalia");
        String fromZebraClass = "\n4.Family - " +familyName+ " \n5.Order - " +orderName;
        return fromAnimalClass + fromZebraClass;
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
            System.out.print("\nFrom superclass, " +animal.printAnimalFeature("Cat", "Animalia", "Chordata", "Mammalia\n"));
            System.out.println("\nFrom superclass, " +animal.printAnimalFeature("Zebra", "Animalia", "Chordata", "Mammalia"));
            Class animalClass = Animal.class;
            String className = animalClass.getName();
            System.out.println("\nClass name: " +className);
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
            // get the superclass of Dog
            Class superClass = animalClass.getSuperclass();
            System.out.println("Superclass: " + superClass.getName());


            Zebra zebra = new Zebra();
            System.out.println("\nFrom Zebra class, " +zebra.printZebraFeatures("Equidae", "Perissodactyla"));


        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            Cat cat = new Cat();
            System.out.println("\nFrom Cat class, " +cat.printCatFeatures("Canidae", "Carnivora"));
            Class catClass = Animal.class;
            String className = catClass.getName();
            System.out.println("\nClass name: " +className);
            String classPackage = String.valueOf(catClass.getPackage());
            System.out.println("Class package: " +classPackage);
            Field[] fields1 = catClass.getDeclaredFields();
            String declaredFields = Arrays.toString(fields1);
            System.out.println("Class fields: " +declaredFields);
            Field[] fields2 = catClass.getFields();
            String classField = Arrays.toString(fields2);
            System.out.println("Class fields: " +classField);
            int classModifier = catClass.getModifiers();// get the access modifier of the class
            String mod = Modifier.toString(classModifier);// convert the access modifier to string
            System.out.println("Class modifier: " +mod);
            // get the superclass of Dog
            Class superClass = catClass.getSuperclass();
            System.out.println("Superclass: " + superClass.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


