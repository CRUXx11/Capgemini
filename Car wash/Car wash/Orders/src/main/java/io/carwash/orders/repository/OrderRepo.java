package io.carwash.orders.repository;


import io.carwash.orders.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends MongoRepository<Order, Integer>{

}

