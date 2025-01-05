public class Main {
    public static void main(String[] args) {
        Student student = new Student("Jeffrey", 23, "Male", "Year 11");
        System.out.println(student);
    }
}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return ("Name: " +name+
                "Age: " +age);
    }
}
class Student extends Person{
    private String gender;
    private String form;

    public Student(String name, int age, String gender, String form) {
        super(name, age);
        this.form = form;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}