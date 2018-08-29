/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author archange
 */
public class FileUploadController {

    boolean bool = false;
    Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

    public String upload(MultipartFile file, String id) {
        //System.out.println(uploadDirectory);
        ///  public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";

        new File(FileUploadController.uploadDirectory).mkdir();
        StringBuilder fileNames = new StringBuilder();

        String nom = file.getOriginalFilename() + "_" + id;
        Path fileNameAndPath = Paths.get(uploadDirectory, nom);

        fileNames.append(file.getOriginalFilename() + " ");

        try {
            Files.write(fileNameAndPath, file.getBytes());
            Files.copy(fileNameAndPath, fileNameAndPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
//System.out.println(fileNames.toString);
        String toto = new String();
        toto = fileNames.toString() + currentTimestamp.toGMTString();
        // model.addAttribute("msg", "Successfully uploaded files " + fileNames.toString());
        return currentTimestamp.toGMTString();

    }

    public File getFile(String name, String id) throws FileNotFoundException {
        String interName = name + "_" + id;
        String nom = uploadDirectory + "/" + interName;
        File file = new File(nom);
        return file;
    }

    public void deleteFile(String name, String id) throws FileNotFoundException {

        File file = getFile(name, id);

        //System.out.println(nom);
        bool = file.delete();
       // System.out.println(bool);

    }

}
