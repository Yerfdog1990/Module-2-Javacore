package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student {
    String name;
    int age;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student's name: " + name +
                ", age = " + age +
                " years.";
    }
}
class ageComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getAge() - student2.getAge();
    }
}
class Main{
    public static ArrayList<Student> studentArrayList = new ArrayList<>();
    public static void main(String[] args) {
        Collections.addAll(studentArrayList,
                new Student(15, "Hosni"),
                new Student(16, "Milcah"),
                new Student(18, "John"),
                new Student(14, "Joyce"));

        Collections.sort(studentArrayList, new ageComparator());

        for(Student elem : studentArrayList){
            System.out.println(elem);
        }
    }
}
