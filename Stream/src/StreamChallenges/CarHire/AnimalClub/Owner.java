package StreamChallenges.CarHire.AnimalClub;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private String name;
    private List<Animal> pets = new ArrayList<>();

    //Constructor
    public Owner(String name) {
        this.name = name;
    }

    //Getter
    public List<Animal> getPets() {
        return pets;
    }
}
