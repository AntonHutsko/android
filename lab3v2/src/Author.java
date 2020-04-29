import java.util.ArrayList;
import java.util.List;

public class Author {
    String name;
    short age;
    List<Book> books;

    public Author(String name, short age) {
        this.name = name;
        this.age = age;
        this.books = new ArrayList<Book>();
    }
}
