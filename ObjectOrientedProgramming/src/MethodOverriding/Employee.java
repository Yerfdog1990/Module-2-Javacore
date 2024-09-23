package MethodOverriding;
/*
In Java, when you create your own classes (like Order, Trade, or Employee), it's important to provide specific implementations for several methods:
    1. equals(): This method checks if two objects are "equal." By default, it checks if both references point to the same object in memory. You usually want to compare the actual content or attributes of the objects instead.
    2. hashCode(): This method returns an integer that represents the object’s memory address. It’s used in hash-based collections (like HashMap). If you override equals(), you should also override hashCode() to ensure that two equal objects have the same hash code.
    3. compareTo(): This method allows you to define how two objects should be compared. This is used for sorting objects. By default, it doesn't do anything useful unless you implement it.
    4. toString(): This method returns a string representation of the object. By default, it returns a string that includes the class name and the object's hash code (like package.class@hashCode). You usually want to override this to provide a more meaningful string representation of your object's attributes.
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private int age;

    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(34, "Godfrey");
        Employee emp2 = new Employee(5, "Cyril");
        Employee emp3 = new Employee(34, "Godfrey");

        System.out.println(emp1);
        System.out.println(emp1.equals(emp3));
        System.out.println(emp1.hashCode());
        System.out.println(emp2.compareTo(emp3));
    }
}
