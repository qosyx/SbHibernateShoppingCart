/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.controller;

import io.swagger.annotations.ApiOperation;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.o7planning.SbHibernateShoppingCart.entity.Order;
import org.o7planning.SbHibernateShoppingCart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author archange
 */
@RestController("OrderController")
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    HttpServletRequest request;

    @ApiOperation(value = "Create order")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Order> createOrder(@RequestBody Order order) throws SQLException {
        Order result = orderService.create(order);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Update order")
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        Order result = orderService.update(order);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Afficher tous les orders")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getAll() {
        List<Order> result = orderService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    
    @ApiOperation(value = "Afficher tous les orders")
    @RequestMapping(method = RequestMethod.GET, value = "list/{customerName}")
    public ResponseEntity<List<Order>> getAllByCus(@PathVariable String customerName) {
        List<Order> result = orderService.getAllByCus(customerName);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
    @ApiOperation(value = "Afficher tous les orders")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Order> getOne(@PathVariable String id) {
        Order result = orderService.getById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
