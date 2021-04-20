package io.carwash.razorpay.service;

import com.razorpay.Order;
import io.carwash.razorpay.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Order> store(List<Order> orders){
        paymentRepository.deleteAll();
       return paymentRepository.saveAll(orders);
    }


}
