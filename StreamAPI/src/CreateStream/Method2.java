package CreateStream;

import java.util.Arrays;
//Creating a Stream using "Arrays."
public class Method2 {
    public static void main(String[] args) {
        String[] stringArray = {"Kenya", "Uganda", "Tanzania", "Rwanda", "Burundi"};
        Arrays.stream(stringArray).forEach(System.out::println);
        // Print a subset of the array elements
        Arrays.stream(stringArray, 1, 4).forEach(System.out::println);
        
    }
}
