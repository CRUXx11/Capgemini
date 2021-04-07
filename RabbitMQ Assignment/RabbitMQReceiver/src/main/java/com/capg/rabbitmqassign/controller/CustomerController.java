package com.capg.rabbitmqassign.controller;

import java.util.List;

import com.capg.rabbitmqassign.model.Customer;
import com.capg.rabbitmqassign.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/create")
    public String create(@RequestParam String firstName, @RequestParam String lastName) {
        Customer p = customerService.create(firstName, lastName);
        return p.toString();
    }

    @RequestMapping("/get")
    public Customer getCustomer(@RequestParam String firstName) {
        return customerService.getByFirstName(firstName);
    }
    @RequestMapping("/getAll")
    public List<Customer> getAll(){
        return customerService.getAll();
    }
    @RequestMapping("/update")
    public String update(@RequestParam String firstName, @RequestParam String lastName) {
        Customer p = customerService.update(firstName, lastName);
        return p.toString();
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName) {
        customerService.delete(firstName);
        return "Deleted "+firstName;
    }
    @RequestMapping ("/deleteAll")
    public String deleteAll() {
        customerService.deleteAll();
        return "Deleted all records";
    }

}