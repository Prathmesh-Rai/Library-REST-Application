package org.prathmesh.library.Controllers;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;
import org.prathmesh.library.Entities.Book;
import org.prathmesh.library.Services.bookServices;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.NOT_MODIFIED;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)

public class bookController {

    @Inject
    bookServices bookServ ;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response storeBook(Book b){
        return Response.ok(bookServ.storeBook(b)).build() ;
    } //CREATE operation

    @GET
    @Path("/listAll")
    public List<Book> returnListOfBooks(){
        return bookServ.listBook() ;
    }   //READ operation

    @GET
    @Path("/getById/{id}")
    public Book getBookById(@PathParam("id") Long id){             //READ operation
        return bookServ.getBookById(id) ;

    }

    @PUT
    @Path("/updateBook/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("id") Long id,Book b){   //UPDATE operation
            Book book = bookServ.getBookById(id);
            if( book == null ){
                return Response.status(NOT_MODIFIED).build() ;
            }
            else{
                book = bookServ.updateBook(id,b) ;
                return Response.ok(book).build() ;
            }

    }

    @DELETE
    @Path("/deleteBook/{id}")
    public Response deleteBook(@PathParam("id") Long id){       //DELETE book
        Book b = bookServ.getBookById(id) ;
        if( b == null ){
            return Response.status(NOT_FOUND).build() ;
        }
        else{
            bookServ.deleteBook(id) ;
            return Response.ok().build() ;
        }
    }

}
