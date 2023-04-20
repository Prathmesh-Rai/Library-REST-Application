package org.prathmesh.library.Entities;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book ;

    private Date issueDate ;
    private Date returnDate ;

    public Transaction(){
        super();
    }

    public Transaction(Long id, Book book, Date issueDate, Date returnDate) {
        this.id = id;
        this.book = book;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
