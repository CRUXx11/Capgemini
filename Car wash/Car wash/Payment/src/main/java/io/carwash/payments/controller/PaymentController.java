package io.carwash.payments.controller;

import io.carwash.payments.model.Payment;
import io.carwash.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Random;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/dopayment")
    public Payment doPayment(@RequestBody Payment payment){
        return paymentService.doPayment(payment);
    }


}