package io.carwash.orders.controller;

import io.carwash.orders.common.TransactionRequest;
import io.carwash.orders.common.TransactionResponse;
import io.carwash.orders.model.Order;
import io.carwash.orders.model.Payment;
import io.carwash.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



@RestController
@CrossOrigin(origins="*")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest){

        return orderService.saveOrder(transactionRequest);
        //do a rest call to payment api
    }





}