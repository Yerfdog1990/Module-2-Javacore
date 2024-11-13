package CreateLambdaExpression;

public interface Citizenship {
    void printCountry(String name);
}
class countryOrigin{
    static void print(Citizenship T, String country){
        T.printCountry("Kenya");
    }
    public static void main(String[] args) {
        Citizenship country = name -> System.out.println(name);
        country.printCountry("Kenya");
        print(name -> System.out.println(name), "Kenya");
    }
}
