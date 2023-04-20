package org.prathmesh.library.Services;

import org.prathmesh.library.Entities.Book;
import org.prathmesh.library.Entities.Transaction;
import org.prathmesh.library.Repository.bookRepository;
import org.prathmesh.library.Repository.transactionRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;


@ApplicationScoped
public class transactionServicesImpl implements transactionServices{

    @Inject
    transactionRepository transRepo ;

    @Inject
    bookRepository bookRepo ;

    @Override
    @Transactional
    public Book issueBook(Long id){
        Book b = bookRepo.findById(id) ;
        Long c =  (long)b.getNoOfBooks() ;
        Long p = transRepo.count("book_id = ?1 and returnDate is null",id );
        if( (c-p) > 0 ){
            createTransaction(id) ;
            return b ;
        }
        else{
            return null ;
        }
    }

    @Override
    @Transactional
    public void createTransaction(Long id){
        Transaction trans = new Transaction() ;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") ;
        Date d = new Date() ;
        formatter.format(d) ;
        trans.setIssueDate(d);
        trans.setBook(bookRepo.findById(id));
        transRepo.persist(trans);
    }

    @Override
    @Transactional
    public Transaction returnBook(Long id){
        Boolean b = getTransactionById(id) ;
        if(b) {
            Transaction trans = transRepo.findById(id);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") ;
            Date d = new Date() ;
            formatter.format(d) ;
            trans.setReturnDate(d);
            return trans ;
        }
        else{
            return null ;
        }
    }

    @Override
    @Transactional
    public Boolean getTransactionById(Long id){
        try {
            Transaction t = transRepo.findById(id);
            Long ID = t.getId() ;
            return true ;
        }
        catch (Exception e){
            e.printStackTrace();
            return false ;
        }
    }

}
