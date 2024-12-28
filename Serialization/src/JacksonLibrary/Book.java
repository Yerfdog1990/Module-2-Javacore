package JacksonLibrary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Book {
    public String title;
    public String author;
    public int pages;

    public static void main(String[] args) throws JsonProcessingException {
        Book book = new Book();
        book.author = " Philip Robbins";
        book.title = "Python, Java, SQL & JavaScript";
        book.pages = 456;

        ObjectMapper mapper = new ObjectMapper();
        String jsonBook = mapper.writeValueAsString(book);
        System.out.println(jsonBook);
    }
}
