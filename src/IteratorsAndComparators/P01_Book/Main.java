package IteratorsAndComparators.P01_Book;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("TheDocumentsintheCase", 2002);
        Book bookTwo = new Book("TheDocumentsintheCase", 1930, "Dorothy Sayers", "Robert Eustace");
        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        System.out.println();
    }
}
