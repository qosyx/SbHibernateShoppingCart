/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.repository;

import java.util.List;
import org.o7planning.SbHibernateShoppingCart.entity.Order;
import org.o7planning.SbHibernateShoppingCart.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author archange
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>{
  ///  List<OrderDetail> findByPRODUCT_ID(String prodcut_id);
    //List<OrderDetail> findByOrder();
}
