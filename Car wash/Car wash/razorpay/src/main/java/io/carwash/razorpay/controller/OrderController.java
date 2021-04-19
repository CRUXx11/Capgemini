package io.carwash.razorpay.controller;

import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import io.carwash.razorpay.service.PaymentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/order")
public class OrderController {

@Autowired
private PaymentService paymentService;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/payments")
    public String getAllPayments() throws RazorpayException {

        RazorpayClient razorpay = new RazorpayClient("rzp_test_oVLnRK0PRIAX1X","pSrLpFSI63js3oaI3Lfik4hP");
        try {
            JSONObject paymentRequest = new JSONObject();

            //supported option filters (from, to, count, skip)
            List<Payment> payments = razorpay.Payments.fetchAll(paymentRequest);
            paymentService.store(payments);
            return payments.toString();
        } catch (RazorpayException e) {
            // Handle Exception
            System.out.println(e.getMessage());
        }

//        RazorpayClient razorpay = new RazorpayClient("rzp_test_oVLnRK0PRIAX1X", "pSrLpFSI63js3oaI3Lfik4hP");
//
//        try {
//            JSONObject paymentRequest = new JSONObject();
//            //supported option filters (from, to, count, skip)
//
//            paymentRequest.put("amount",49999);
//            paymentRequest.put("currency", "INR");
//            Order order=razorpay.Orders.create(paymentRequest);
//            return order.toString();
//        } catch (RazorpayException e) {
//            // Handle Exception
//            System.out.println(e.getMessage());
//        }
        return "Failed";
    }
}
