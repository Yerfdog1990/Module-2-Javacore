package StreamChallenges.CarHire;

public class Car {
    private String model;
    private Color color;
    private int YoM;

    public Car(int yoM, Color color, String model) {
        YoM = yoM;
        this.color = color;
        this.model = model;
    }

    public int getYoM() {
        return YoM;
    }

    public Color getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }
}
