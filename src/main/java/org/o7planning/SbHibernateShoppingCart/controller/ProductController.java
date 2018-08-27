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
import org.o7planning.SbHibernateShoppingCart.entity.Account;
import org.o7planning.SbHibernateShoppingCart.entity.Product;
import org.o7planning.SbHibernateShoppingCart.helpers.AccountWS;
import org.o7planning.SbHibernateShoppingCart.repository.AccountRepository;
import org.o7planning.SbHibernateShoppingCart.service.AccountService;
import org.o7planning.SbHibernateShoppingCart.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author archange
 */
@RestController("ProductController")
@RequestMapping("/products")
//@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProduitService produitService;

    @Autowired
    HttpServletRequest request;

    //@Autowired(required = true)
    @ApiOperation(value = "Create product")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody

    public ResponseEntity<Product> createAccountws(@RequestBody Product product) throws SQLException {
        Product result = produitService.create(product);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available products")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Product>> findAllProduct() throws Exception {
        HttpStatus httpStatus = null;
        //  List<AccountWS> accountWS = new ArrayList<AccountWS>();
        List<Product> products = produitService.readAll();

        httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(products, httpStatus);
    }

}
