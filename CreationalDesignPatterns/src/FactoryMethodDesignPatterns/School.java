package FactoryMethodDesignPatterns;

import java.util.Scanner;

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
class academicDeanFactory extends SchoolFactory{
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

        try(Scanner booking = new Scanner(System.in)){

            SchoolFactory schoolFactory = null;
            while (schoolFactory == null){
                System.out.print("Enter the office you want to visit: ");
                String userInput = booking.nextLine();
                try{
                    switch (userInput.toLowerCase()){
                        case "principal":
                            schoolFactory = new schoolHeadFactory();
                            break;
                        case ("counselor"):
                            schoolFactory = new schoolCounselorFactory();
                            break;
                        case "dean":
                            schoolFactory = new academicDeanFactory();
                            break;
                        case "class":
                            schoolFactory = new classTeacherFactory();
                            break;
                        case "accountant":
                            schoolFactory = new schoolAccountantFactory();
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid office! Try again.");
                    }
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
            schoolFactory.renderService();
        }
    }
}
