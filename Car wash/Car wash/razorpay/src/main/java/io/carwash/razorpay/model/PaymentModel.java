package io.carwash.razorpay.model;

import com.razorpay.Payment;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PaymentModel {
    private Payment payment;
}

