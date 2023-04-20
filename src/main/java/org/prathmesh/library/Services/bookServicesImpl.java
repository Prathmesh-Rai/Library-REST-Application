package org.prathmesh.library.Services;

import org.prathmesh.library.Entities.Book;
import org.prathmesh.library.Repository.bookRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class bookServicesImpl implements bookServices{

    @Inject
    bookRepository bookRepo ;
    @Override
    @Transactional
    public Book storeBook(Book b){
        bookRepo.persist(b);
        return b ;
    }

    @Override
    @Transactional
    public List<Book> listBook(){
        return bookRepo.listAll() ;
    }

    @Override
    @Transactional
    public Book getBookById(Long id){
        try{
            Book b = bookRepo.findById(id) ;
            Long ID = b.getId() ;
            return b ;
        }
        catch (Exception e){
            System.out.println("No book found!!!..Please try again.");
            e.printStackTrace();
            return null ;
        }
    }

    @Override
    @Transactional
    public Book updateBook(Long id,Book b){
        Book currBook = bookRepo.findById(id) ;
        currBook.setNoOfPages(b.getNoOfPages());
        currBook.setNoOfBooks(b.getNoOfBooks());
        currBook.setName(b.getName());
        currBook.setAuthor(b.getAuthor());
        bookRepo.persist(currBook);
        return currBook ;
    }

    @Override
    @Transactional
    public void deleteBook(Long id){
        bookRepo.delete(bookRepo.findById(id));
    }



}
