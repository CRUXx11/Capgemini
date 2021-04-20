package io.carwash.razorpay.repository;

import com.razorpay.Order;
import com.razorpay.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PaymentRepository extends MongoRepository<Order,String> {


}
