package JacksonLibrary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

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

            // Create json ObjectMapper
            ObjectMapper mapper1 = new ObjectMapper();
            mapper1.enable(SerializationFeature.INDENT_OUTPUT);

            // Serialize the object to a json file
            File jsonFile = new File("file.json");
            mapper1.writeValue(jsonFile, book);

            // Serialize the object to a JSON string and print it
            String jsonString = mapper1.writeValueAsString(book);
            System.out.println("\nSerialized json object:\n" +jsonString);

            // Deserialize the object from the  json file
            Book deserializeBook1 = mapper1.readValue(jsonFile, Book.class);
            System.out.println("\nDeserialized json object:\n" +deserializeBook1);

            // Create xml ObjectMapper
            ObjectMapper mapper2 = new XmlMapper();
            mapper2.enable(SerializationFeature.INDENT_OUTPUT);

            // Serialize the object to a xml file
            File xmlFile = new File("file.xml");
            mapper2.writeValue(xmlFile, book);

            // Serialize the object to xml string and print it
            String xmlString = mapper2.writeValueAsString(book);
            System.out.println("\nSerialized xml object:\n" +xmlString);


            // Deserialize the object from the  xml file
            Book deserializeBook2 = mapper2.readValue(xmlFile, Book.class);
            System.out.println("\nDeserialized xml object:\n" +deserializeBook2);

            // Create YAML ObjectMapper
            ObjectMapper mapper3 = new YAMLMapper();
            mapper3.enable(SerializationFeature.INDENT_OUTPUT);
            // Serialize the object to an YAML file
            File yamlFile = new File("file.yaml");
            mapper3.writeValue(yamlFile, book);

            // Serialize the object to YAML string and print it
            String yamlString = mapper3.writeValueAsString(book);
            System.out.println("\nSerialized YAML object:\n" +yamlString);

            // Deserialize the object from the  yaml file
            Book deserializeBook3 = mapper3.readValue(yamlFile, Book.class);
            System.out.println("\nDeserialized YAML object:\n" +deserializeBook3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
