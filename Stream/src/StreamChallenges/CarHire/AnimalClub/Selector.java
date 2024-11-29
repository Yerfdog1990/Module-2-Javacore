package StreamChallenges.CarHire.AnimalClub;

import java.util.List;

public class Selector {
    private static List<Owner> ownerList;

    public static List<Owner> getOwnerList() {
        return ownerList;
    }

    static void collectData(){
        final Owner owner1 = new Owner("Ronan Turner");
        owner1.getPets().addAll(List.of(
                new Cat(3, Color.BLACK, "Baron"),
                new Cat(2, Color.DARK_GREY, "Sultan"),
                new Dog(4, Color.WHITE, "Elsa")
        ));

        final Owner owner2 = new Owner("Scarlet Murray");
        owner2.getPets().addAll(List.of(
                new Cat(7, Color.FOXY, "Ginger"),
                new Cat(5, Color.FOXY, "Oscar"),
                new Dog(10, Color.BLUE, "Admiral")
        ));

        final Owner owner3 = new Owner("Felicity Mason");
        owner3.getPets().addAll(List.of(
                new Dog(7, Color.FOXY, "Arnold"),
                new Pig(5, Color.LIGHT_GREY, "Vacuum Cleaner")
        ));

        final Owner owner4 = new Owner("Mitchell Stone");
        owner4.getPets().addAll(List.of(
                new Parrot(6, Color.YELLOW, "Yoga"),
                new Snake(10, Color.MAGENTA, "Mr. Boa")
        ));

        final Owner owner5 = new Owner("Jonathan Snyder");
        owner5.getPets().addAll(List.of(
                new Parrot(4, Color.GREEN, "Yolo"),
                new Cat(16, Color.BLACK, "Fisher"),
                new Cat(14, Color.WHITE, "Zorro"),
                new Cat(10, Color.LIGHT_GREY, "Margo"),
                new Cat(1, Color.FOXY, "Brawler")
        ));
        ownerList = List.of(owner1, owner2, owner3, owner4, owner5);
    }
}
