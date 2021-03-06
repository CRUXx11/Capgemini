package io.carwash.gateway.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class FallbackController {

    @RequestMapping("/orderFallback")

    public Mono<String> orderServiceFallback(){
        return Mono.just("Order Service is taking too long to respond or is down.Please try again later");
    }
    @RequestMapping("/paymentFallback")
    public Mono<String> paymentServiceFallback(){
        return Mono.just("Payment Service is taking too long to respond or is down.Please try again later");
    }
    @RequestMapping("/customerFallback")
    public Mono<String> customerServiceFallback(){
        return Mono.just("Customer Service is taking too long to respond or is down.Please try again later");
    }
    @RequestMapping("/adminFallback")
    public Mono<String> adminServiceFallback(){
        return Mono.just("Admin Service is taking too long to respond or is down.Please try again later");
    }
}
