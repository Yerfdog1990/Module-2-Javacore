/**
 * This package contains classes related to lambda expression demonstrations
 * using citizenship and country information.
 */
package CreateLambdaExpression;

/**
 * A functional interface that defines a contract for printing
 * country information for a given name.
 */
@FunctionalInterface
public interface Citizenship {
    void printCountry(String name);
}
/**
 * A class that demonstrates the usage of Citizenship functional interface
 * with lambda expressions for printing country information.
 */
class countryOrigin{
    /**
     * Static method to demonstrate passing lambda expressions as parameters.
     * @param T The Citizenship implementation
     * @param country The country name to be printed
     */
    static void print(Citizenship T, String country){
        T.printCountry(country);
    }
    /**
     * Main method to demonstrate different ways of using lambda expressions
     * with the Citizenship interface.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {

    // Lambda expression that prints the country name
    Citizenship country = name -> System.out.println(name);
    country.printCountry("Kenya");
    // Direct lambda expression passed to print method to display the country name
    print(name -> System.out.println(name), "Kenya");
    }
}
