package org.o7planning.SbHibernateShoppingCart;

import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbHibernateShoppingCartApplication {
    public static void main(String[] args) throws SQLException { 
        SpringApplication.run(SbHibernateShoppingCartApplication.class, args);

    }
}
