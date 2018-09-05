package org.o7planning.SbHibernateShoppingCart.helpers;

import org.o7planning.SbHibernateShoppingCart.client.OrderDetailClient;
import org.o7planning.SbHibernateShoppingCart.client.ProductClient;
import org.o7planning.SbHibernateShoppingCart.entity.Order;
import org.o7planning.SbHibernateShoppingCart.entity.OrderDetail;
import org.o7planning.SbHibernateShoppingCart.entity.Product;
import org.o7planning.SbHibernateShoppingCart.repository.OrderDetailRepository;
import org.o7planning.SbHibernateShoppingCart.repository.OrderRepository;
import org.o7planning.SbHibernateShoppingCart.repository.ProduitRepository;
import org.o7planning.SbHibernateShoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class ProduitAchatWS {


    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private OrderRepository orderRepository;

    public ProduitAchat build(String idproduit, String idOrder) throws IOException {
        Product product = produitRepository.getOne(idproduit);
        Order order = orderRepository.getOne(idOrder);
        ProduitAchat produitAchat = new ProduitAchat(product, order);
        return produitAchat;

    }
}
