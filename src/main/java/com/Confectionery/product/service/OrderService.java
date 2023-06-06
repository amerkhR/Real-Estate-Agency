package com.Confectionery.product.service;

import com.Confectionery.product.entity.Order;
import com.Confectionery.product.entity.User;
import com.Confectionery.product.repository.OrderRepository;
import com.Confectionery.product.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final UserRepository userRepository;


    public void saveOrder(Principal principal, Order order){
        order.setUser(getUserByPrincipal(principal));
        log.info("Saving new Order. {}" , order.getName());
        orderRepository.save(order);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }


    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }


    public List<Order> getOrdersForUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
