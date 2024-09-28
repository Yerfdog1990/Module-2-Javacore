package OOP3_Composition_Aggregation_Inheritance;
/*
2. One-to-Many Association
Description: In a one-to-many association, one instance of a class is associated with multiple instances of another class.
For example, a teacher can teach multiple students.
 */
import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String teacherName;
    private List<Student> studentList;

    public Teacher(String teacherName) {
        this.studentList = new ArrayList<>();
        this.teacherName = teacherName;
    }
    public void addStudents(Student students){
        studentList.add(students);
    }
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
class Student{
    private String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
class OneToMany{
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Godfrey");
        teacher.addStudents(new Student("Joseph"));
        teacher.addStudents(new Student("Kaew"));
        teacher.addStudents(new Student("Jeslin"));
        teacher.addStudents(new Student("Aileen"));
        teacher.addStudents(new Student("Pear"));

        System.out.println(teacher.getTeacherName()+ " teaches the following students:");
        List<Student> studentList = teacher.getStudentList();
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i+1)+ "." +studentList.get(i).getStudentName());
        }
    }
}
