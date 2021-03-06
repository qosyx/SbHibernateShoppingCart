/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.entity;

/**
 *
 * @author archange
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.o7planning.SbHibernateShoppingCart.enumration.EtatProduct;

@Entity
@Table(name = "products", schema = "targetSchemaName")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable {

    private static final long serialVersionUID = -1000119078147252957L;

    @Id
    @Column(name = "Code", length = 20, nullable = false)
    private String code;

    @Column(name = "Name", length = 255, nullable = false)
    private String name;

    @Column(name = "Price", nullable = false)
    private double price;

    @Lob
    @Column(name = "Image", nullable = true)
    private String image;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Create_Date", nullable = false)
    private Date createDate;

    @Column(name = "etat")
    private EtatProduct etat;

    public EtatProduct getEtat() {
        return etat;
    }

    public void setEtat(EtatProduct etat) {
        this.etat = etat;
    }


    public Product() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
}
