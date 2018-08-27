/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author archange
 */
@Controller
//@CrossOrigin(origins = "*")
public class HomeController {

    /**
     * The web service of the home page
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}