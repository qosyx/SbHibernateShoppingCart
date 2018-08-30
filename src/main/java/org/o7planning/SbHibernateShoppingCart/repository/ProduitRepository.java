/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.repository;

import org.o7planning.SbHibernateShoppingCart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author archange
 */
public interface  ProduitRepository extends JpaRepository<Product, Object>{

   
}
