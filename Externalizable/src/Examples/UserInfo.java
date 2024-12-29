package Examples;

import java.io.*;
import java.util.Base64;

public class UserInfo implements Externalizable {
    private static final long serialVersionUID = 1L;
    private String password;
    private String firstName;
    private String lastName;

    //Parameterized constructor
    public UserInfo(String lastName, String firstName, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
    }
    //Non-parameterized constructor
    public UserInfo() {
    }
    //Getters
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return ("\nFirst name: " +firstName+
                "\nLast name: "+lastName+
                "\nPassword: " +password);
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getFirstName());
        out.writeObject(this.getLastName());
        out.writeObject(this.encryptUserInfo(getPassword()));
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        firstName = (String)in.readObject();
        lastName = (String)in.readObject();
        password = this.decryptUserInfo((String)in.readObject());
    }
    private String encryptUserInfo(String data){
        String encryptedData = Base64.getEncoder().encodeToString(data.getBytes());
        System.out.println("\nEncrypted password: " +encryptedData);
        return encryptedData;
    }
    private String decryptUserInfo(String data){
        String decryptedData = new String(Base64.getDecoder().decode(data));
        System.out.println("\nDecrypted password: " +decryptedData);
        return decryptedData;
    }
    //Main method
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("Ochieng\'", "John", "xyzqr");
        UserInfo newUserInfo = null;
        //Serialize the UserInfo data
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("userInfo.ser"));
            out.writeObject(userInfo);
            out.flush();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //Deserialize the UserInfo data
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("userInfo.ser"));
            newUserInfo = (UserInfo) in.readObject();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
//        System.out.println("\nSerialized user info: " +userInfo);
//        System.out.println("\nDeserialized user info: " +newUserInfo);
    }
}
