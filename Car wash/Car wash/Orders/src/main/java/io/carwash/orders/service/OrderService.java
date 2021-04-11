package io.carwash.orders.service;

import io.carwash.orders.common.TransactionRequest;
import io.carwash.orders.common.TransactionResponse;
import io.carwash.orders.model.Order;
import io.carwash.orders.model.Payment;
import io.carwash.orders.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RefreshScope
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    @Lazy
    private RestTemplate restTemplate;


    @Value("${microservice.payments-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    public TransactionResponse saveOrder(TransactionRequest transactionRequest){
        String response="";
        Order order=transactionRequest.getOrder();
        Payment payment=transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        //rest call
        Payment paymentResponse=restTemplate.postForObject("http://PAYMENT-SERVICE/payment/dopayment",payment,Payment.class);
        response=paymentResponse.getPaymentStatus().equals("Success")?"Payment Successful and booking confirmed":"Payment failed order added to cart";

        //

        orderRepo.save(order);
        return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }


}