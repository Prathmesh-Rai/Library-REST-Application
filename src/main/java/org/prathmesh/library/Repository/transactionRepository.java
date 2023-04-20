package org.prathmesh.library.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.prathmesh.library.Entities.Transaction;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class transactionRepository implements PanacheRepository<Transaction> {
}
