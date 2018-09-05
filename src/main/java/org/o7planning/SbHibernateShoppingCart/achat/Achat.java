/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.achat;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.sql.SQLException;
import org.o7planning.SbHibernateShoppingCart.entity.Product;
import org.o7planning.SbHibernateShoppingCart.enumration.EtatProduct;
import org.o7planning.SbHibernateShoppingCart.service.OrderDetailService;
import org.o7planning.SbHibernateShoppingCart.service.ProductService;
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
@RestController("AchatController")
@RequestMapping("/ventes")
@Api(value = "Achat API", description = "Achat API")
@CrossOrigin(origins = "*")
public class Achat {

    @Autowired
    ProductService productService;
    
    @Autowired
    OrderDetailService orderDetailService;
    
    @ApiOperation(value = "Update product")
    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public ResponseEntity<Boolean> updateProduct(@PathVariable String id) throws SQLException, IOException {
       Product product =  productService.getById(id);
        product.setEtat(EtatProduct.Vendu);
        productService.UpdateById(id); 
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    
}
