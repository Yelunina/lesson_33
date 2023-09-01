package books.dao;

import books.model.Book;

import java.util.function.Predicate;

public class LibraryImpl implements Library {

    private Book[] books;
    private int size;

    // конструктор
    public LibraryImpl(int capacity) {
        books = new Book[capacity];
    }

    @Override
    public boolean abbBook(Book book) {
        // проверки на "плохие" данные на входе - не null, не больше capacity, не уже существующую книгу
        if(book == null || size == books.length || findBookByIsbn(book.getIsbn()) != null) {
            return false;
        }
        books[size] = book; // на последнее место в массиве ставим книгу
        size++;
        return true;
    }

    @Override
    public Book removeBook(long isbn) {
        // TODO проверка на корректный isbn 13 цифр
        // обежать массив, найти совпадение по isbn
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) {
                Book bookForRemove = books[i];
                books[i] = books[size - 1]; // последнюю книгу поставили на место найденной
                books[size - 1] = null; // затираем последний элемент
                size--;
                return bookForRemove;
            }
        }
        return null;
    }

    @Override
    public Book findBookByIsbn(long isbn) {
        // обежать массив, найти совпадение по isbn
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) {
                return books[i]; // объект, элемент массива
            }
        }
        return null;
    }

    @Override
    public Book[] findBookByAuthor(String author) {
        Predicate<Book> predicate = book -> book.getAuthor().equals(author);
        return findBooksByPredicate(predicate);
    }

    private Book[] findBooksByPredicate(Predicate<Book> predicate) {
        int count = 0;
        // считаем кол-во книг, которые попадают под условие
        for (int i = 0; i < size; i++) {
            if(predicate.test(books[i])) {
                count++;
            }
        }
        // заполняем массив
        Book[] res = new Book[count];
        for (int i = 0, j = 0 ; i < res.length; i++) {
            if(predicate.test(books[i])){
                res[j++] = books[i];
            }
        }
        return res;
    }

    @Override
    public int size() {
        return size;
    }
}