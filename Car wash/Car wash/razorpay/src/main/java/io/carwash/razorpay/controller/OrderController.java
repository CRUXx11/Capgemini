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
            return payments.toString();
        } catch (RazorpayException e) {
            // Handle Exception
            System.out.println(e.getMessage());
        }
        return "All payments fetch failed";
    }

    @RequestMapping("/orders")
    public String getAllOrders() throws RazorpayException{
        RazorpayClient razorpay = new RazorpayClient("rzp_test_oVLnRK0PRIAX1X", "pSrLpFSI63js3oaI3Lfik4hP");
        try {
            JSONObject paymentRequest = new JSONObject();
            List<Order> order=razorpay.Orders.fetchAll(paymentRequest);
            paymentService.store(order);
            return order.toString();
        } catch (RazorpayException e) {
            // Handle Exception
            System.out.println(e.getMessage());
        }
        return "All Orders Fetch Failed";
    }
    @RequestMapping("/orderId/{orderbyid}")
    public String getOrderbyId(@PathVariable("orderbyid") String orderId) throws RazorpayException{
        RazorpayClient razorpay = new RazorpayClient("rzp_test_oVLnRK0PRIAX1X", "pSrLpFSI63js3oaI3Lfik4hP");
        try {
            Order order=razorpay.Orders.fetch(orderId);
            return order.toString();
        } catch (RazorpayException e) {
            // Handle Exception
            System.out.println(e.getMessage());
        }
        return "Order Fetch Failed";
    }
    @RequestMapping("/paymentId/{paymentbyid}")
    public String getPaymentById(@PathVariable("paymentbyid") String id ) throws RazorpayException{
        RazorpayClient razorpay = new RazorpayClient("rzp_test_oVLnRK0PRIAX1X", "pSrLpFSI63js3oaI3Lfik4hP");
        try {
            Payment payment=razorpay.Payments.fetch(id);
            return payment.toString();
        } catch (RazorpayException e) {
            // Handle Exception
            System.out.println(e.getMessage());
        }
        return "Payment Fetch Failed";
    }

}
