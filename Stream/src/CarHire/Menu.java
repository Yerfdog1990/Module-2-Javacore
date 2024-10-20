package CarHire;

import java.util.List;

public class Menu {
    private static List <Customer> customerList;

    public List<Customer> customer() {
        return customerList;
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static void customerLog(){
        final Customer customer1 = new Customer("John");
        customer1.getCarModel().addAll(List.of(
                new Benz(2021, Color.BLACK, " Mercedes-Benz C200"),
                new Lexus(2019, Color.WHITE, "Lexus ES350"),
                new Mazda(2020, Color.DARK_BROWN, "Mazda CX5")
        ));

        final Customer customer2 = new Customer("Maria");
        customer2.getCarModel().addAll(List.of(
                new Suzuki(2017, Color.RED, "Suzuki Escudo"),
                new Honda(208, Color.BLACK, "Honda CR-V"),
                new Suzuki(2023, Color.SILVER, "Suzuki Swift")
        ));

        final Customer customer3 = new Customer("Tom");
        customer3.getCarModel().addAll(List.of(
                new Toyota(2024, Color.WHITE, "Toyota Prado"),
                new Benz(2020, Color.DARK_BROWN, "Mercedes-Benz GLC300"),
                new Honda(2017, Color.BLACK, "Honda HR-V")
        ));

        final Customer customer4 = new Customer("Okoth");
        customer4.getCarModel().addAll(List.of(
                new Lexus(2022, Color.BLACK, "Lexus ES350 "),
                new Toyota(2021, Color.WHITE, "Toyota RAV4"),
                new Mazda(2018, Color.DARK_BROWN, "Mazda CX3")
        ));

        final Customer customer5 = new Customer("Joyce");
        customer5.getCarModel().addAll(List.of(
                new Benz(2020, Color.BLACK, "Mercedes-Benz GLA200"),
                new Suzuki(2018, Color.WHITE, "Suzuki Vitara"),
                new Toyota(2023, Color.WHITE, "Toyota Premio")
        ));
        customerList = List.of(customer1, customer2, customer3, customer4, customer5);
    }
}
