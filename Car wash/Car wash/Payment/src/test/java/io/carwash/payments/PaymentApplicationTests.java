package io.carwash.payments;

import io.carwash.payments.repository.PaymentRepo;
import io.carwash.payments.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentApplicationTests {

	@Autowired
	private PaymentService paymentService;

	@MockBean
	private PaymentRepo paymentRepo;

	@Test
	void contextLoads() {
	}





}
