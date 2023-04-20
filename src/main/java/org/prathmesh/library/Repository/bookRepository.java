package org.prathmesh.library.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.prathmesh.library.Entities.Book;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class bookRepository implements PanacheRepository<Book> {
}
