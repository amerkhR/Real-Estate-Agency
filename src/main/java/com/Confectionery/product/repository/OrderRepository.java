package com.Confectionery.product.repository;

import com.Confectionery.product.entity.Order;
import com.Confectionery.product.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);
    List<Order> findByUserId(Long userId);
    Order findOrderByIdAndUserId(Long orderId, Long userId);
}