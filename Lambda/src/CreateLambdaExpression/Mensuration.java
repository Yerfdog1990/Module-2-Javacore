package CreateLambdaExpression;

@FunctionalInterface
public interface Mensuration {
    double calculateSurfaceArea(double length, double width);
}
class SurfaceAreaCalculator{
    public static void main(String[] args) {
        Mensuration rectangle = (length, width) -> length * width;
        System.out.printf(
                "Surface area of a rectangle: %.2f cm²%n", rectangle.calculateSurfaceArea(5, 10));
        Mensuration triangle = (base, height) -> (base * height) / 2;
        System.out.printf(
                "Surface area of a triangle: %.2f cm²%n", triangle.calculateSurfaceArea(10, 5));
        Mensuration cylinder =
                (radius, height) -> (2 * Math.PI * radius * height) + (2 * Math.PI * radius * radius);
        System.out.printf(
                "Surface area of a cylinder: %.2f cm²%n", cylinder.calculateSurfaceArea(5, 10));
        Mensuration cone = (radius, height) -> (Math.PI * radius * (radius + height)) / 3;
        System.out.printf("Surface area of a cone: %.2f cm²%n", cone.calculateSurfaceArea(5, 10));
    }
}
