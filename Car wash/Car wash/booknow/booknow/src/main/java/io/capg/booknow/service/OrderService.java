package io.capg.booknow.service;
import io.capg.booknow.model.Order;
import io.capg.booknow.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Order saveOrder(Order order){
        return orderRepo.insert(order);
    }
}
