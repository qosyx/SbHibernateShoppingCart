package org.o7planning.SbHibernateShoppingCart;

import java.sql.SQLException;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SbHibernateShoppingCartApplication {

    public static void main(String[] args) throws SQLException {

        SpringApplication.run(SbHibernateShoppingCartApplication.class, args);

    }
}
