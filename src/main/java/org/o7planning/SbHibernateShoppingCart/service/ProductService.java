/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.service;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.o7planning.SbHibernateShoppingCart.entity.Product;
import org.o7planning.SbHibernateShoppingCart.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author archange
 */
@Component
public class ProductService {

    public String uploadDirectory = System.getProperty("user.dir") + "/uploads";

    @Autowired
    private ProduitRepository produitRepository;

    public Product create(Product product, String nameFichier) throws SQLException {
        String nomFichierComplet = nameFichier + "_" + product.getCode();
        product.setImage(nomFichierComplet);
        product.setCreateDate(Date.from(Instant.MIN));
        produitRepository.save(product);

        return product;
    }

    public Product update(Product product, String nameFichier) throws SQLException {
        String nomFichierComplet = nameFichier + "_" + product.getCode();
        product.setImage(nomFichierComplet);
        produitRepository.save(product);

        return product;
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

}
