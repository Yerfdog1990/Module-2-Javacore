package StreamChallenges.CarHire;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Menu.customerLog();

        final List <String> findModel = Menu.getCustomerList().stream()
                .flatMap(customer -> customer.getCarModel().stream()) // Flatten the list of car models.
                .filter(carModel -> Toyota.class.equals(carModel.getClass())) // Filter only Toyota.
                .filter(toyota ->Color.WHITE == toyota.getColor()) // Filter only black Toyota
                .sorted((car1, car2) -> car2.getYoM() - car1.getYoM()) // Sort by YoM in descending order
                .map(Car::getModel) // Extract car model names
                .collect(Collectors.toList()); // Collect the car model names into a list

        findModel.forEach(System.out::println);
    }
}
