package StreamChallenges.CarHire;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Car> carModel = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public List<Car> getCarModel() {
        return carModel;
    }
}
