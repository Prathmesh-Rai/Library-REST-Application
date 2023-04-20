package org.prathmesh.library.Services;

import org.prathmesh.library.Entities.Book;
import org.prathmesh.library.Entities.Transaction;


public interface transactionServices {
    public Book issueBook(Long id) ;

    public void createTransaction(Long id) ;

    public Transaction returnBook(Long id) ;

    public Boolean getTransactionById(Long id) ;

}
