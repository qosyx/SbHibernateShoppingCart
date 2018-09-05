/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.helpers;

import org.o7planning.SbHibernateShoppingCart.entity.OrderDetail;
import org.o7planning.SbHibernateShoppingCart.entity.Product;

/**
 * @author archange
 */
public class ProduitAchat {

    private String codeproduit;

    private String nameproduit;

    private double priceproduit;

    private String imageproduit;

    private int quanity;

    private double price;

    private String idOrderDetail;

    private int idOrder;

    private double amount;

    public ProduitAchat() {
    }


    public ProduitAchat(Product product, OrderDetail orderDetail) {

        this.codeproduit = product.getCode();
        this.amount = orderDetail.getAmount();
        this.idOrder = orderDetail.getOrder().getOrderNum();
        this.idOrderDetail = orderDetail.getId();
        this.imageproduit = product.getImage();
        this.nameproduit = product.getName();
        this.price = product.getPrice();
        this.quanity = orderDetail.getQuanity();
    }

    public String getCodeproduit() {
        return codeproduit;
    }

    public void setCodeproduit(String codeproduit) {
        this.codeproduit = codeproduit;
    }

    public String getNameproduit() {
        return nameproduit;
    }

    public void setNameproduit(String nameproduit) {
        this.nameproduit = nameproduit;
    }

    public double getPriceproduit() {
        return priceproduit;
    }

    public void setPriceproduit(double priceproduit) {
        this.priceproduit = priceproduit;
    }

    public String getImageproduit() {
        return imageproduit;
    }

    public void setImageproduit(String imageproduit) {
        this.imageproduit = imageproduit;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(String idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
