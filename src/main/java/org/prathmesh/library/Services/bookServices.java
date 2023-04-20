package org.prathmesh.library.Services;

import org.prathmesh.library.Entities.Book;

import java.util.List;

public interface bookServices{
    public Book storeBook(Book b);

    public List<Book> listBook() ;

    public Book getBookById(Long id) ;

    public Book updateBook(Long id,Book b) ;

    public void deleteBook(Long id) ;

}
