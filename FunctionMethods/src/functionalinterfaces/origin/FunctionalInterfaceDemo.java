package functionalinterfaces.origin;

public class FunctionalInterfaceDemo {
  // Before Java 8, when using an anonymous class
  public static void main(String[] args) {
    new Rectangle() {
      @Override
      public double area(double length, double width) {
        return length * width;
      }
    };
    System.out.println();
  }

  interface Rectangle {
    double area(double length, double width);
  }
}
