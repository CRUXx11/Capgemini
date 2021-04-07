package com.capg.rabbitmqassign.repository;


import com.capg.rabbitmqassign.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepo extends MongoRepository<Customer, String>{
    public Customer findByFirstName(String firstName);
}
