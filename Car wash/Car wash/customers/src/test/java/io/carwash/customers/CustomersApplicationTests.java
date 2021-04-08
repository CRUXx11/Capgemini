package io.carwash.customers;

import io.carwash.customers.model.Customer;
import io.carwash.customers.repository.CustomerRepo;
import io.carwash.customers.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomersApplicationTests {

	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerRepo customerRepo;

	@Test
	void contextLoads() {
	}

	//test for create method
	@Test
	public void createTest() {
		int a=customerRepo.findAll().size();
		Customer c=new Customer("test","pass2","test2@test2.com","1231231231");
		when(customerRepo.save(c)).thenReturn(c);
		assertEquals(c, customerService.create(c));
	}

	//test for getAll method
	@Test
	public void getAllTest() {
		when(customerRepo.findAll()).thenReturn(Stream
				.of(new Customer("test", "pass", "test@gmail.com", "1234567890"), new Customer("test2", "pass2", "test2@gmail.com", "1234567891")).collect(Collectors.toList()));
		assertEquals(2, customerService.getAll().size());
	}



}
