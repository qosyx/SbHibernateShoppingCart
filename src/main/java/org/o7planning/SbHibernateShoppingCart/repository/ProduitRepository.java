/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.repository;

import java.util.List;
import java.util.Optional;
import org.o7planning.SbHibernateShoppingCart.entity.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author archange
 */
@Repository
public interface  ProduitRepository extends JpaRepository<Product,String>{

   
}
