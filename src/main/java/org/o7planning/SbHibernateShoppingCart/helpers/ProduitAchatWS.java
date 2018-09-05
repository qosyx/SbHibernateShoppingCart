package org.o7planning.SbHibernateShoppingCart.helpers;

import org.o7planning.SbHibernateShoppingCart.client.OrderDetailClient;
import org.o7planning.SbHibernateShoppingCart.client.ProductClient;
import org.o7planning.SbHibernateShoppingCart.entity.OrderDetail;
import org.o7planning.SbHibernateShoppingCart.entity.Product;

import java.io.IOException;

public class ProduitAchatWS {



    public ProduitAchat build(String idproduit, String idOrderDetail) throws IOException{
        ProductClient productClient = new ProductClient();
        OrderDetailClient orderDetailClient = new OrderDetailClient();

        Product product = productClient.getProduct(idproduit);
        OrderDetail orderDetail = orderDetailClient.read(idOrderDetail);
        ProduitAchat produitAchat = new ProduitAchat(product,orderDetail);
        return produitAchat;

    }
}
