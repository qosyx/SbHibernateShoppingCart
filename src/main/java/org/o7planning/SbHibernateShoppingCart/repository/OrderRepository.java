/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.repository;

import java.util.List;
import org.o7planning.SbHibernateShoppingCart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author archange
 */
public interface OrderRepository extends JpaRepository<Order, String>{
    
    List<Order> findByCustomerName(String customerName);
    //  List<Order> findByname(String customerName);
     // @Query("select t from Order  t where t.#{#entityName} = ?1")
  //List<Order> findAllByAttribute(String attribute);
}
