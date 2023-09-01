package books.model;
import java.util.Objects;

public class Book implements Comparable<Book>{
    private long isbn;
    private int yearOfPublishing;
    private String author;

    public Book(long isbn, int yearOfPublishing, String author){
        this.isbn = isbn;
        this.yearOfPublishing = yearOfPublishing;
        this.author = author;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", yearOfPublishing=" + yearOfPublishing + ", author='" + author  + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public int compareTo(Book o) {
        int res = this.author.compareTo(o.author); // по автору
        if (res != 0) {
            return res;
        }
        return Integer.compare(this.yearOfPublishing, o.yearOfPublishing); // по году выпуска
    }
}