package io.carwash.razorpay.service;

import com.razorpay.Payment;
import io.carwash.razorpay.model.PaymentModel;
import io.carwash.razorpay.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    //Create operation
    public List<Payment> store(List<Payment> payment) {
        paymentRepository.deleteAll();
        return paymentRepository.saveAll(payment);
    }

}
