package AnimalClub;

public abstract class Animal {
    private String name;
    private Color color;
    private int age;

    //Constructor
    public Animal(int age, Color color, String name) {
        this.age = age;
        this.color = color;
        this.name = name;
    }

    //Getters
    public int getAge() {
        return age;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
