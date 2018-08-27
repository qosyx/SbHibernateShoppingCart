package org.o7planning.SbHibernateShoppingCart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.o7planning.SbHibernateShoppingCart.entity.Account;
import org.o7planning.SbHibernateShoppingCart.helpers.AccountWS;
import org.o7planning.SbHibernateShoppingCart.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbHibernateShoppingCartApplication {

    public static void main(String[] args) throws SQLException {

        
        SpringApplication.run(SbHibernateShoppingCartApplication.class, args);

    }
}
