package io.carwash.payments.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.carwash.payments.model.Payment;
import io.carwash.payments.repository.PaymentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    private Logger log= LoggerFactory.getLogger(PaymentService.class);

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(PaymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        try {
            log.info("PaymentService request: {}",new ObjectMapper().writeValueAsString(payment));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return paymentRepo.save(payment);
    }
    public String PaymentProcessing(){
        return new Random().nextBoolean()?"Success":"False";
    }

    public Payment findPaymentByOrderId(int orderId) {
       Payment payment=paymentRepo.findByOrderId(orderId);
        try {
            log.info("PaymentService findPaymentByOrderId request: {}",new ObjectMapper().writeValueAsString(payment));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return payment;
    }
}