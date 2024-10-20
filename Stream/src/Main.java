import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List <String> stringList = new ArrayList<>();
        stringList.add("https://google.com");
        stringList.add("https://linkedin.com");
        stringList.add("https://yandex.com");

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