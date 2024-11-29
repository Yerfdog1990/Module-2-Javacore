package CreateStreams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FromArrays {
    public static void main(String[] args) {
        String[] arrays = {"Kenya", "Uganda", "Tanzania", "Uganda"};
        Stream<String> stringStream = Arrays.stream(arrays);
        System.out.printf("East African countries: %s%n", stringStream.collect(Collectors.toList()));
    }
}
