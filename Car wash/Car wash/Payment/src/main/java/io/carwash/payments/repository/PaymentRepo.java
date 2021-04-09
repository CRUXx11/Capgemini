package io.carwash.payments.repository;


import io.carwash.payments.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepo extends MongoRepository<Payment, Integer>{
    Payment findByOrderId(int orderId);
}

