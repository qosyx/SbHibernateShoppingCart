/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart;

import org.junit.Test;

/**
 *
 * @author archange
 */
import java.io.File;
import java.util.EnumSet;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import static org.o7planning.SbHibernateShoppingCart.SchemaGeneratorDemo.createDataBase;
import static org.o7planning.SbHibernateShoppingCart.SchemaGeneratorDemo.dropDataBase;

public class SchemaGenerator {

    public static final String SCRIPT_FILE = "exportScript.sql";

    private static SchemaExport getSchemaExport() {

        SchemaExport export = new SchemaExport();
        // Script file.
        File outputFile = new File(SCRIPT_FILE);
        String outputFilePath = outputFile.getAbsolutePath();

        System.out.println("Export file: " + outputFilePath);

        export.setDelimiter(";");
        export.setOutputFile(outputFilePath);

        // No Stop if Error
        export.setHaltOnError(false);
        //
        return export;
    }

    public static void dropDataBase(SchemaExport export, Metadata metadata) {
        // TargetType.DATABASE - Execute on Databse
        // TargetType.SCRIPT - Write Script file.
        // TargetType.STDOUT - Write log to Console.
        EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);

        export.drop(targetTypes, metadata);
    }

    public static void createDataBase(SchemaExport export, Metadata metadata) {
        // TargetType.DATABASE - Execute on Databse
        // TargetType.SCRIPT - Write Script file.
        // TargetType.STDOUT - Write log to Console.

        EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);

        SchemaExport.Action action = SchemaExport.Action.CREATE;
        //
        export.execute(targetTypes, action, metadata);

        System.out.println("Export OK");

    }

    @Test
    public void generateTables() {

        String configFileName = "hibernate-mysql.cfg.xml";

        // Create the ServiceRegistry from hibernate-xxx.cfg.xml
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
                .configure(configFileName).build();

        // Create a metadata sources using the specified service registry.
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        SchemaExport export = getSchemaExport();

        System.out.println("Drop Database...");
        // Drop Database
        dropDataBase(export, metadata);

        System.out.println("Create Database...");
        // Create tables
        createDataBase(export, metadata);
    }

}