package FactoryMethodDesignPatterns;

public interface School {
    void selectOffice();
}
class schoolHead implements School{
    @Override
    public void selectOffice() {
        System.out.println("Welcome to head of school office. You can now book an appointment.");
    }
}
class schoolCounselor implements School{
    @Override
    public void selectOffice() {
        System.out.println("Welcome to school counselor office. You can now book an appointment.");
    }
}
class academicDean implements School{
    @Override
    public void selectOffice() {
        System.out.println("Welcome to academic dean office. You can now book an appointment.");
    }
}
class classTeacher implements School{
    @Override
    public void selectOffice() {
        System.out.println("Welcome to class teacher office. You can now book an appointment.");
    }
}
class schoolAccountant implements School{
    @Override
    public void selectOffice() {
        System.out.println("Welcome to school accountant's office. You can now book an appointment.");
    }
}
abstract class SchoolFactory{
    abstract School bookAppointment();
    public void renderService(){
        School school = bookAppointment();
        school.selectOffice();
    }
}
class schoolHeadFactory extends SchoolFactory{
    @Override
    School bookAppointment() {
        return new schoolHead();
    }
}
class schoolCounselorFactory extends SchoolFactory{
    @Override
    School bookAppointment() {
        return new schoolCounselor();
    }
}
class academicDeadFactory extends SchoolFactory{
    @Override
    School bookAppointment() {
        return new academicDean();
    }
}
class classTeacherFactory extends SchoolFactory{
    @Override
    School bookAppointment() {
        return new classTeacher();
    }
}
class schoolAccountantFactory extends SchoolFactory{
    @Override
    School bookAppointment() {
        return new schoolAccountant();
    }
}
class FactoryMethodDemo2{
    public static void main(String[] args) {

    }
}
