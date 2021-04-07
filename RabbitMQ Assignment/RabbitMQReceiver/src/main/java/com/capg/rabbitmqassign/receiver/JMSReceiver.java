package com.capg.rabbitmqassign.receiver;

import com.capg.rabbitmqassign.model.Customer;
import org.springframework.stereotype.Component;
import java.util.concurrent.CountDownLatch;
@Component
public class JMSReceiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}