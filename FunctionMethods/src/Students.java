import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Students {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        Collections.addAll(stringArrayList, "John", "George", "June", "peter");
        stringArrayList.forEach((s) -> System.out.println(s)); //Functional method
        stringArrayList.forEach(System.out ::println); //Method reference
    }
}
