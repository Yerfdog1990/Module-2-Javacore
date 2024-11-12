package CreateLambdaExpression;

public interface Citizenship {
    void printCountry(String name);
}
class countryOrigin{
    public static void main(String[] args) {
        Citizenship country = name -> System.out.println(name);
        country.printCountry("Kenya");
    }
}
