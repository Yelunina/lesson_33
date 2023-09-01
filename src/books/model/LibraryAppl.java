package books.model;

import books.dao.LibraryImpl;
import books.model.Book;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryAppl {
    public static void main(String[] args) {

        LibraryImpl library = new LibraryImpl(100); // это объект - библиотека

        Book[] books = new Book[6]; // это массив, в котором хранятся книги в библиотеке

        books[0] = new Book(100L, 1960, "Pushkin");
        books[1] = new Book(200L, 1970, "Lermontov");
        books[2] = new Book(300L, 1950, "Tolstoi");
        books[3] = new Book(400L, 1975, "Dostoevski");
        books[4] = new Book(500L, 1930, "Chekhov");
        books[5] = new Book(600L, 1900, "Pushkin");

        // заполняем библиотеку, добавляем объекты books[i] методом add в объект library
        for (int i = 0; i < books.length; i++) {
            library.abbBook(books[i]);
        }

        System.out.println(library.size());
        System.out.println("========Unsored =======================");
        printBooks(books);
        Arrays.sort(books);// сортируем массив
        System.out.println("========Sored =======================");
        printBooks(books); // печатаем


        Comparator<Book> comparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare((int) o1.getIsbn(), (int) o2.getIsbn());
            }
        };

        Arrays.sort(books, comparator); // sort by comparator
        System.out.println("=======================");
        printBooks(books);

        Arrays.sort(books, (b1, b2) -> { // sort by lambda
            return b1.getAuthor().compareTo(b2.getAuthor());
        });

        System.out.println("=======================");
        printBooks(books);

        System.out.println("=======================");

        Book[] pushkin = library.findBookByAuthor("Pushkin");
        printBooks(pushkin);

    }

    public static void printBooks(Book[] books){
        for (Book book : books) {
            System.out.println(book);
        }
    }

}