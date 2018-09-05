/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.controller;

import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.o7planning.SbHibernateShoppingCart.entity.Product;
import org.o7planning.SbHibernateShoppingCart.enumration.EtatProduct;
import org.o7planning.SbHibernateShoppingCart.helpers.ProduitAchat;
import org.o7planning.SbHibernateShoppingCart.helpers.ProduitAchatWS;
import org.o7planning.SbHibernateShoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author archange
 */
@RestController("ProductController")
@RequestMapping("/products")
//@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    HttpServletRequest request;

    @ApiOperation(value = "Create product")
    @RequestMapping(method = RequestMethod.POST, value = "/{nameFichier}")
    public ResponseEntity<Product> createProduct(@RequestBody Product product, @PathVariable String nameFichier) throws SQLException, IOException {
        Product result = productService.create(product, nameFichier);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Update product")
    @RequestMapping(method = RequestMethod.PUT, value = "/{nameFichier}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable String nameFichier) throws SQLException, IOException {
        Product result = productService.update(product, nameFichier);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Create file")
    @RequestMapping(method = RequestMethod.POST, value = "file/{code}")
    public ResponseEntity<String> createfile(@RequestParam MultipartFile file, @PathVariable String code) throws SQLException, IOException {

        String result = productService.createfile(file, code);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Update file")
    @RequestMapping(method = RequestMethod.PUT, value = "file/{code}/{olderName}")
    public ResponseEntity<String> updatefile(@RequestParam MultipartFile file, @PathVariable String code, @PathVariable String olderName) throws SQLException, IOException {
        String result = productService.updatefile(file,code, olderName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available products")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAllProduct() throws Exception {
        HttpStatus httpStatus = null;
        //  List<ProductWS> productWS = new ArrayList<ProductWS>();
        List<Product> products = productService.getAll();
        httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(products, httpStatus);
    }

    @ApiOperation(value = "View a list of available products")
    @RequestMapping(method = RequestMethod.GET, value = "/{code}")
    public ResponseEntity<Product> findByUserName(@PathVariable("code") String code) throws Exception {
        Product product = new Product();
        HttpStatus httpStatus = null;
        try {
            product = productService.getById(code);
            httpStatus = HttpStatus.OK;
        } catch (SQLException ex) {

            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(product, httpStatus);
    }

     
    
    
      @ApiOperation(value = "View a list of available products  by etat")
    @RequestMapping(method = RequestMethod.GET,value = "etat/{etat}")
    public ResponseEntity<List<Product>> findByEtat(@PathVariable("etat") EtatProduct etatProduct) throws Exception {
        HttpStatus httpStatus = null;
        //  List<ProductWS> productWS = new ArrayList<ProductWS>();
        List<Product> products = productService.getByEtat(etatProduct);
        httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(products, httpStatus);
    }


    @ApiOperation(value = "View a list of available products")
    @RequestMapping(method = RequestMethod.GET, value = "produit/{customerName}")
    public ResponseEntity<List<ProduitAchat>> findByProd(@PathVariable("customerName") String customerName) throws Exception {
        HttpStatus httpStatus = null;
        //  List<ProductWS> productWS = new ArrayList<ProductWS>();
        List<ProduitAchat> productAchat = productService.build(customerName);
        httpStatus = HttpStatus.OK;

        return new ResponseEntity<>(productAchat, httpStatus);
    }




}
