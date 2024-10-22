package CloneMethod;

public class PointA implements Cloneable{
    private int i;
    private int j;

    //Constructor
    public PointA(int i, int j) {
        this.j = j;
        this.i = i;
    }

    //Getters
    public int getJ() {
        return j;
    }

    public int getI() {
        return i;
    }

    //clone() method is overridden to allow cloning using the default behavior provided by the Object class.
    //How it works: The super.clone() method is called, which performs a shallow copy of the object (copies the primitive fields i and j).
    //Key point: The class A is marked Cloneable, meaning it allows cloning without throwing an exception. The override here enables A objects to be cloned.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class PointB extends PointA{
    private String name;

    //Constructor
    public PointB(int j, int i, String name) {
        super(j, i);
        this.name = name;
    }

    //Getter
    public String getName() {
        return name;
    }

    //clone() method is overridden to disallow cloning.
    //How it works: Instead of calling super.clone(), this method throws a CloneNotSupportedException, which signals that cloning objects of class B is not supported.
    //Key point: Even though B extends A, the override here explicitly prevents cloning of B objects.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
class PointC extends PointB{
    //Constructor
    public PointC(int i, int j, String name) {
        super(i, j, name);
    }

    //clone() method is overridden to create a deep copy of C objects.
    //How it works: Instead of relying on super.clone(), it manually creates a new C object using the constructor, passing the values obtained from getI(), getJ(), and getName(). This ensures that a new C object is created with the same state as the original.
    //Key point: This override ensures that a new C object is created and returned, effectively implementing cloning by manually constructing the new object.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new PointC(getI(), getJ(), getName());
    }
}
class Main{
    public static void main(String[] args) {

        // Demonstrating cloning for Class A
        try{
            PointA originalPoint = new PointA(2,5);
            PointA clonedPoint = (PointA) originalPoint.clone();
            System.out.println("Original point: ("+originalPoint.getI()+ ", " +originalPoint.getJ()+ ")");
            System.out.println("Cloned point: ("+clonedPoint.getI()+ ", " +clonedPoint.getJ()+ ")");
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        // Demonstrating cloning for Class B (CloneNotSupportedException is expected)
        try{
            PointB originalPoint = new PointB(3, 9, "Point B");
            PointB clonedPoint = (PointB) originalPoint.clone(); // This will throw CloneNotSupportedException
            System.out.println("\nOriginal point: ("+originalPoint.getI()+ ", " +originalPoint.getJ()+ ")");
            System.out.println("Cloned point: ("+clonedPoint.getI()+ ", " +clonedPoint.getJ()+ ")");
        }catch (CloneNotSupportedException e){
            System.out.println("\nSorry, cloning not allowed in the class PointB");
        }
        // Demonstrating cloning for Class C (Deep cloning)
        try{
            PointC originalPoint = new PointC(3, 9, "Object C");
            PointC clonedPoint = (PointC) originalPoint.clone(); // This will throw CloneNotSupportedException
            System.out.println("\nOriginal point: ("+originalPoint.getI()+ ", " +originalPoint.getJ()+ "), Object name = " +originalPoint.getName());
            System.out.println("Cloned point: ("+clonedPoint.getI()+ ", " +clonedPoint.getJ()+ "), Object name = " +clonedPoint.getName());
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
