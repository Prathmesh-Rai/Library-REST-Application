package org.prathmesh.library.Controllers;

import jdk.javadoc.doclet.Reporter;
import org.prathmesh.library.Entities.Book;
import org.prathmesh.library.Entities.Transaction;
import org.prathmesh.library.Services.bookServices;
import org.prathmesh.library.Services.transactionServices;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;


@Path("/api/books")
public class transactionController {

    @Inject
    bookServices bookServ ;

    @Inject
    transactionServices transServ ;

    @Path("/issueBook/{id}")
    @GET
    public Response issueBook(@PathParam("id") Long id){
        Book b = bookServ.getBookById(id) ;
        if(b != null){
            b = transServ.issueBook(id) ;
            if( b != null ){
                return Response.ok().build() ;
            }
            else{
                return Response.status(NOT_FOUND).build() ;
            }
        }
        else{
            return Response.status(NOT_FOUND).build() ;
        }
    }

    @GET
    @Path("/returnBook/{id}")
    public Response returnBook(@PathParam("id") Long id){
        Transaction t = transServ.returnBook(id) ;
        if( t != null ){
            return Response.ok().build() ;
        }
        else{
            return Response.status(NOT_FOUND).build() ;
        }
    }

}
