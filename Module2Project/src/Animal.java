import java.util.*;

public abstract class Animal {
    protected double weight;
    protected int maxPerLocation;
    protected int maxSpeed;
    protected double foodRequired;

    //Abstract methods
    public abstract void eat();
    public abstract void move();
    public abstract void breed();
}

