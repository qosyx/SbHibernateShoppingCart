/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.o7planning.SbHibernateShoppingCart.entity.Order;
import org.o7planning.SbHibernateShoppingCart.entity.OrderDetail;
import org.o7planning.SbHibernateShoppingCart.entity.Product;
import org.o7planning.SbHibernateShoppingCart.enumration.EtatProduct;
import org.o7planning.SbHibernateShoppingCart.gson.HibernateProxyTypeAdapter;
import org.o7planning.SbHibernateShoppingCart.helpers.ProduitAchat;
import org.o7planning.SbHibernateShoppingCart.repository.OrderDetailRepository;
import org.o7planning.SbHibernateShoppingCart.repository.OrderRepository;
import org.o7planning.SbHibernateShoppingCart.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author archange
 */
@Component
public class ProductService {

    public String uploadDirectory = System.getProperty("user.dir") + "/uploads";

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    OrderDetailService orderDetailService;

    public Product create(Product product, String nameFichier) throws SQLException {
        String nomFichierComplet = nameFichier + "_" + product.getCode();
        product.setImage(nomFichierComplet);

        //product.setCreateDate(Date.from(Instant.MIN));
        produitRepository.save(product);

        return product;
    }

    public Product update(Product product, String nameFichier) throws SQLException {
        String nomFichierComplet = nameFichier + "_" + product.getCode();
        product.setImage(nomFichierComplet);
        produitRepository.save(product);

        return product;
    }

    public boolean UpdateById(String id) throws SQLException {
        Product product = produitRepository.getOne(id);
        produitRepository.save(product);
        return true;
    }

    public String createfile(MultipartFile file, String id) throws SQLException {
        FileUploadController fileUploadController = new FileUploadController();
        fileUploadController.upload(file, id);
        //  produitRepository.save(product);
        return "fait";
    }

    public String updatefile(MultipartFile file, String id, String olderName) throws SQLException, FileNotFoundException {

        FileUploadController fileUploadController = new FileUploadController();
        fileUploadController.deleteFile(olderName, id);
        fileUploadController.upload(file, id);
        //  produitRepository.save(product);
        return "fait";
    }

    public List<Product> getAll() throws SQLException {
        List<Product> products = new ArrayList<Product>();
        products = produitRepository.findAll();
        return products;

    }

    public Product getById(String id) throws SQLException {
        return produitRepository.getOne(id);
    }

    public boolean delete(Product product) throws SQLException {
        produitRepository.delete(product);
        return true;
    }

    public List<Product> getByEtat(EtatProduct etatProduct) {
        List<Product> products = new ArrayList<Product>();
        products = produitRepository.findByetat(etatProduct);
        return products;
    }

    public List<ProduitAchat> build(String customerName) throws IOException {

        List<ProduitAchat> produitAchatList = new ArrayList<ProduitAchat>();

        //List<Order>orderList = orderRepository.findByCustomerName(customerName);
        List<OrderDetail> orderDetailList = orderDetailRepository.findAll();

        for (OrderDetail orderDetail : orderDetailList) {
            Order order = orderDetail.getOrder();
            if (order.getCustomerName().equals(customerName)){
                System.out.println(order.getId());
                GsonBuilder b = new GsonBuilder();
                b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
                Gson gson = b.create();
                System.out.println(gson.toJson(order));
            }
        }

        return produitAchatList;
    }


}
