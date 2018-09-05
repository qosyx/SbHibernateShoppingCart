/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.service;

import java.util.List;

import org.o7planning.SbHibernateShoppingCart.entity.Order;
import org.o7planning.SbHibernateShoppingCart.entity.OrderDetail;
import org.o7planning.SbHibernateShoppingCart.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author archange
 */
@Component
public class OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    
    public OrderDetail create(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
        return orderDetail;
    }

    public OrderDetail update(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
        return orderDetail;
    }

    public List<OrderDetail> getAll() {
        List<OrderDetail> orderDetails = orderDetailRepository.findAll();
        return orderDetails;
    }

    public OrderDetail getById(String id) {
        return orderDetailRepository.getOne(id);
    }

    public OrderDetail getByCus(String customerName) {
        return orderDetailRepository.getOne(customerName);
    }

    /*
    public List<OrderDetail> getAllByCus(String productId) {
        List<OrderDetail> orderDetails = orderDetailRepository.findByPRODUCT_ID(productId);
        return orderDetails;
    }*/

    public boolean delete(String id) {
        boolean b = false;
        if (orderDetailRepository.existsById(id)) {
            orderDetailRepository.deleteById(id);
        }
        return true;
    }





    public String getOrderById(Order order) {
        System.out.println(orderDetailRepository.getOne(order.getId()).getId());
        return orderDetailRepository.getOne(order.getId()).getId();


    }
    
    
}
