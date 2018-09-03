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
import org.o7planning.SbHibernateShoppingCart.entity.OrderDetail;
import org.o7planning.SbHibernateShoppingCart.service.OrderDetailService;
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
@RestController("OrderDetailController")
@RequestMapping("/orderdetails")
@CrossOrigin(origins = "*")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;
    
    @Autowired
    HttpServletRequest request;

    @ApiOperation(value = "Create order")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OrderDetail> createOrder(@RequestBody OrderDetail orderDetail) throws SQLException {
        OrderDetail result = orderDetailService.create(orderDetail);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Update order")
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<OrderDetail> updateOrder(@RequestBody OrderDetail orderDetail) {
        OrderDetail result = orderDetailService.update(orderDetail);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Afficher tous les orders")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OrderDetail>> getAll() {
        List<OrderDetail> result = orderDetailService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    /*
    @ApiOperation(value = "Afficher tous les orders")
    @RequestMapping(method = RequestMethod.GET, value = "list/{productId}")
    public ResponseEntity<List<OrderDetail>> getAllByCus(@PathVariable String productId) {
        List<OrderDetail> result = orderDetailService.getAllByCus(productId);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }*/
    @ApiOperation(value = "Afficher tous les orders")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<OrderDetail> getOne(@PathVariable String id) {
        OrderDetail result = orderDetailService.getById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
            
}
