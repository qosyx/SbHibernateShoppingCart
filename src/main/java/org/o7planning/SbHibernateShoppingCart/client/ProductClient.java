/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.client;

import java.io.IOException;
import org.o7planning.SbHibernateShoppingCart.client.utils.GsonUtils;
import org.o7planning.SbHibernateShoppingCart.client.utils.PropertiesFileUtils;
import org.o7planning.SbHibernateShoppingCart.entity.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author archange
 */
public class ProductClient {

    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public ProductClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils = new PropertiesFileUtils();
    }

    public Product create(Product product,String nameFichier) throws IOException {
        
        //  String uri = propertiesFileUtils.getAppUrl("publication-service-fonctionnel-create");
      String uri="http://localhost:8080/onlinebank/products";
        String uriGet = uri + "/" + nameFichier;
        String requestBody = GsonUtils.toJSONWithoutClassName(product);
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        HttpEntity request = new HttpEntity(requestBody, headers);

        String apiResponse = restTemplate.postForObject(uriGet,
                request, String.class);
        product = GsonUtils.getObjectFromJson(apiResponse, Product.class);

        return product;
    }


    public Product getProduct(String code) throws IOException {
        String uri="http://localhost:8080/onlinebank/products";
        String uriGet = uri + "/" + code;

        ResponseEntity<String> response = restTemplate.getForEntity(uriGet,String.class);
        String jsonData = response.getBody();
        Product product  = GsonUtils.getObjectFromJson(jsonData,Product.class);
        return product;
    }



}
