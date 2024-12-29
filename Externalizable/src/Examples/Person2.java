package Examples;

import java.io.*;
import java.util.Base64;

//Super class
public class Person2 implements Externalizable {
    private static final long serialVersionUID = 1L;
    private static String name;
    private static String gender;

    public Person2() {
    }
    public Person2(String gender, String name) {
        this.gender = gender;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getGender());
        out.writeObject(this.getName());
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String)in.readObject();
        gender = (String)in.readObject();
    }
    //Subclass
    static class Employee extends Person2 implements Externalizable{
        private static final long serialVersionUID = 1L;
        private String department;
        private String employeeID;

        //Default constructor
        public Employee() {
        }
        public Employee(String gender, String name, String department, String employeeID) {
            super(gender, name);
            this.department = department;
            this.employeeID = employeeID;
        }
        public String getDepartment() {
            return department;
        }
        public String getEmployeeID() {
            return employeeID;
        }
        @Override
        public String toString() {
            return ("\nName: " +name+
                    "\nGender: " +gender+
                    "\nEmployee ID: " +employeeID+
                    "\nDepartment: " +department);
        }
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.getDepartment());
            out.writeObject(this.encryptData(getEmployeeID()));
            super.writeExternal(out);
        }
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            department = (String)in.readObject();
            employeeID = this.decryptData((String)in.readObject());
            super.readExternal(in);
        }
        private String encryptData(String data){
            String encryptedData = Base64.getEncoder().encodeToString(data.getBytes());
            System.out.println("\nEncrypted data: " +encryptedData);
            return encryptedData;
        }
        private String decryptData(String data){
            String decryptedData = new String(Base64.getDecoder().decode(data));
            System.out.println("Decrypted data: " +decryptedData);
            return decryptedData;
        }
    }
    //Main method
    public static void main(String[] args) {
        Employee serializedEmployee = new Employee("Male", "George", "Science", "012GO");
        Employee deserializedEmployee = null;
        File file = new File("employee1.ser");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(serializedEmployee);
            out.flush();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            deserializedEmployee = (Employee)in.readObject();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("\nSerialize employee: " +serializedEmployee);
        System.out.println("\nDeserialize employee: " +deserializedEmployee);
    }
}

