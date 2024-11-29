package General;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ConvertTypes {
    public static void main(String[] args) {
        //Convert string to integer
        Stream<String> stringStream1 = Stream.of("10", "20", "30", "40", "50", "60", "70", "80");
        Stream<Integer> integerStream1 = stringStream1.map(Integer::valueOf);
        integerStream1.forEach(System.out::println);

        //Convert integer to string
        Stream<Integer> integerStream2 = Stream.of(1,2,3,4,5,6,7,8);
        Stream<String> stringStream2 = integerStream2.map(String::valueOf);
        stringStream2.forEach(System.out::println);

        //Covert string to URL
        List <String> stringList = new ArrayList<>();
        stringList.add("https://linkedin.com");
        stringList.add("https://facebook.com");
        stringList.add("https://instagram.com");
        stringList.add("https://x.com");

        Stream<URI> uriStream = stringList.stream().map(str -> {try {
            return new URI(str);
        }catch (URISyntaxException e){
            e.printStackTrace();
            return null;
        }
        });
        uriStream.forEach(System.out::println);
    }
}
