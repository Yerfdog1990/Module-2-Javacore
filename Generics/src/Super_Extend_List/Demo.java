package Super_Extend_List;

public class Demo <T>{
    T data;

    public Demo(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public static  <T> void printData(T data){
        System.out.println("Data: " +data);
    }

  // Main method
  public static void main(String[] args) {
    Demo stringData = new Demo("Hello world");
    Demo intDate = new Demo(34);
    Demo doubleData = new Demo(4.56);
    Demo booleanData = new Demo(true);
    Demo floatData = new Demo(3.14f);
    Demo charData = new Demo('A');
    Demo objectData = new Demo(new Object());

    // Print data for all examples
    Demo.printData(stringData.getData());
    Demo.printData(intDate.getData());
    Demo.printData(doubleData.getData());
    Demo.printData(booleanData.getData());
    Demo.printData(floatData.getData());
    Demo.printData(charData.getData());
    Demo.printData(objectData.getData());
  }
}
