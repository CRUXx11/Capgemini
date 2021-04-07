package com.capg.rabbitmqassign.service;

import java.util.List;

import com.capg.rabbitmqassign.model.Customer;
import com.capg.rabbitmqassign.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    //Create operation
    public Customer create(String firstName, String lastName) {
        return customerRepo.insert(new Customer(firstName, lastName));
    }
    //Retrieve operation
    public List<Customer> getAll(){
        return customerRepo.findAll();
    }
    public Customer getByFirstName(String firstName) {
        return customerRepo.findByFirstName(firstName);
    }
    //Update operation
    public Customer update(String firstName, String lastName) {
        Customer p = customerRepo.findByFirstName(firstName);
        p.setLastName(lastName);
        return customerRepo.save(p);
    }
    //Delete operation
    public void deleteAll() {
        customerRepo.deleteAll();
    }
    public void delete(String firstName) {
        Customer p = customerRepo.findByFirstName(firstName);
        customerRepo.delete(p);
    }
}