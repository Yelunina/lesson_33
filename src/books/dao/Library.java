package books.dao;

import books.model.Book;

import books.model.Book;

public interface Library {
    boolean abbBook(Book book);
    Book removeBook(long isbn);
    Book findBookByIsbn(long isbn);
    Book[] findBookByAuthor(String author);
    int size();
}