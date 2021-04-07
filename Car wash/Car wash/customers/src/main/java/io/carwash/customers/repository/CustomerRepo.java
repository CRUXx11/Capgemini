package io.carwash.customers.repository;


import io.carwash.customers.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepo extends MongoRepository<Customer, String>{
    public Customer findByEmail(String Email);
}

