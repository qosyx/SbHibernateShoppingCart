/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.service;

import java.util.List;
import org.o7planning.SbHibernateShoppingCart.entity.Order;
import org.o7planning.SbHibernateShoppingCart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author archange
 */
@Component
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order create(Order order) {
        orderRepository.save(order);
        return order;
    }

    public Order update(Order order) {
        orderRepository.save(order);
        return order;
    }

    public List<Order> getAll() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    public Order getById(String id) {
        return orderRepository.getOne(id);
    }

    public Order getByCus(String customerName) {
        return orderRepository.getOne(customerName);
    }

    
    public List<Order> getAllByCus(String customerName) {
        List<Order> orders = orderRepository.findByCustomerName(customerName);
        return orders;
    }

    public boolean delete(String id) {
        boolean b = false;
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        }
        return true;
    }
}
