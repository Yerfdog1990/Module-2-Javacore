package OOP3_Composition_Aggregation_Inheritance;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;

/*
3. Many-to-Many Association
Description: In a many-to-many association, multiple instances of one class can be associated with multiple instances of another class.
For example, an instructor can be long to multiple departments based on job their description, and each department can have multiple instructors.
 */
public class Department {
    private String departmentName;
    List<Instructor> instructorList;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.instructorList = new ArrayList<>();
    }
    public void recordInstructor(Instructor instructor){
        instructorList.add(instructor);
        instructor.recordDepartment(this);// Maintain bidirectional relationship
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
class Instructor{
    private String instructorName;
    List<Department> departmentList;

    public Instructor(String instructorName) {
        this.instructorName = instructorName;
        this.departmentList = new ArrayList<>();
    }

    public void recordDepartment(Department department){
        departmentList.add(department);
        //department.recordInstructor(this);// Maintain bidirectional relationship
    }
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorNName) {
        this.instructorName = instructorNName;
    }
}
class ManyToMany{
    public static void main(String[] args) {
        Department mathsDepartment = new Department("Mathematics");
        Department scienceDepartment = new Department("Science");
        Department languageDepartment = new Department("Languages");
        Department humanityDepartment = new Department("Humanities");

        Instructor instructor1 = new Instructor("Godfrey Ouma");
        Instructor instructor2 = new Instructor("Cyril Okoth");
        Instructor instructor3 = new Instructor("Cyrek Odhiambo");
        Instructor instructor4 = new Instructor("Rosemary Omollo");

        mathsDepartment.recordInstructor(instructor1);
        mathsDepartment.recordInstructor(instructor2);
        mathsDepartment.recordInstructor(instructor3);

        scienceDepartment.recordInstructor(instructor1);
        scienceDepartment.recordInstructor(instructor2);
        scienceDepartment.recordInstructor(instructor3);

        humanityDepartment.recordInstructor(instructor2);
        humanityDepartment.recordInstructor(instructor3);
        humanityDepartment.recordInstructor(instructor4);

        languageDepartment.recordInstructor(instructor2);
        languageDepartment.recordInstructor(instructor3);
        languageDepartment.recordInstructor(instructor4);

        //List of instructors
        List<Instructor> allInstructors = new ArrayList<>();
        allInstructors.add(instructor1);
        allInstructors.add(instructor2);
        allInstructors.add(instructor3);
        allInstructors.add(instructor4);

        for(Instructor instructor: allInstructors){
            System.out.println(instructor.getInstructorName()+ " belongs to the following departments: ");

            List<Department> departments = instructor .getDepartmentList();
            for (int i = 0; i < departments.size(); i++) {
                System.out.println((i+1)+". " +departments.get(i).getDepartmentName());
            }
        }
    }
}
