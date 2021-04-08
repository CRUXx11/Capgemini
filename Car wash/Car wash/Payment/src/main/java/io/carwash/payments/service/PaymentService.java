package io.carwash.payments.service;

import io.carwash.payments.model.Payment;
import io.carwash.payments.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(PaymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepo.save(payment);
    }
    public String PaymentProcessing(){
        return new Random().nextBoolean()?"Success":"False";
    }
}