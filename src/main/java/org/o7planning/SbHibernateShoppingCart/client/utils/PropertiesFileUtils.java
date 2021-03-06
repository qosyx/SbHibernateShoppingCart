package org.o7planning.SbHibernateShoppingCart.client.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by darextossa on 11/30/17.
 */
public class PropertiesFileUtils {

    public String getAppUrl(String url) throws IOException {
        Properties props = new Properties();
        props.load(getClass().getResourceAsStream("/clients.properties"));
        return props.getProperty(url);
    }
}
