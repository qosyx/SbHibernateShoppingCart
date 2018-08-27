/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.service;

import java.util.List;
import org.o7planning.SbHibernateShoppingCart.entity.Product;
import org.o7planning.SbHibernateShoppingCart.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author archange
 */
@Component
public class ProduitService {
    
   @Autowired
    private ProduitRepository produitRepository;
    
    public Product create(Product product) {
        produitRepository.save(product);
        return product;
    }
    
    public Product update(Product product) {
        produitRepository.save(product);
        return product;
    }

    public void delete(Product product) {
        produitRepository.delete(product);
    }

    public List<Product> readAll() {
        List<Product> products = produitRepository.findAll();
        return products;
    }
    
    public Product readById(String code) {
        Product product = produitRepository.getOne(code);
        return product;
    }
    
}
