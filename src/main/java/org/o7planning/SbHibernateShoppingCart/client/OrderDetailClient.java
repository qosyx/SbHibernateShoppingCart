/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import org.o7planning.SbHibernateShoppingCart.client.utils.PropertiesFileUtils;
import org.o7planning.SbHibernateShoppingCart.entity.OrderDetail;
import org.o7planning.SbHibernateShoppingCart.entity.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author archange
 */
public class OrderDetailClient {

    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public OrderDetailClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils = new PropertiesFileUtils();
    }

    public OrderDetail read(String id) throws IOException {

        //  String uri = propertiesFileUtils.getAppUrl("publication-service-fonctionnel-create");
        String uri = "http://localhost:8081/onlinebank/orderdetails";
        String uriGet = uri + "/" + id;

        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        HttpEntity request = new HttpEntity(headers);
        Gson gson = new Gson();
        String apiResponse = restTemplate.getForObject(uriGet,
                String.class);
        System.out.println(apiResponse);
        java.lang.reflect.Type typeOfObjectsListNew = new TypeToken<OrderDetail>() {
        }.getType();
        OrderDetail orderDetail = gson.fromJson(apiResponse, typeOfObjectsListNew);
        return orderDetail;
    }

}
