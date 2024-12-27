package JacksonLibrary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Book {
    public String title;
    public String author;
    public int pages;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        try {
            Book book = new Book();
            book.author = " Philip Robbins";
            book.title = "Python, Java, SQL & JavaScript";
            book.pages = 456;

            //Serialize fields using Jackson library
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("book.json");
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, book);
            System.out.println("Serialized JSON written to file: book.json");

            //Deserialize fields using Jackson library
            Book deserializeBook = mapper.readValue(file, Book.class);
            System.out.println(deserializeBook);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
