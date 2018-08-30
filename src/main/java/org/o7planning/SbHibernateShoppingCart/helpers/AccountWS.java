/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.helpers;

import com.google.common.base.Charsets;
import java.io.UnsupportedEncodingException;
import static java.lang.Math.log;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;
import org.o7planning.SbHibernateShoppingCart.entity.Account;

/**
 *
 * @author archange
 */
public final class AccountWS {

    private String userName;
    private String password;
    private boolean active;
    private String userRole;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }


    public AccountWS() {
    }
    

    public byte[] encrypt(String value) {
        byte[] encrypted = null;
        try {

            byte[] raw = new byte[]{'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
            Key skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] iv = new byte[cipher.getBlockSize()];

            IvParameterSpec ivParams = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParams);
            encrypted = cipher.doFinal(value.getBytes());
            System.out.println("encrypted string:" + encrypted.length);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return encrypted;
    }

    public byte[] decrypt(byte[] encrypted) {

        byte[] original = null;
        Cipher cipher = null;
        try {
            byte[] raw = new byte[]{'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
            Key key = new SecretKeySpec(raw, "AES");
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            //the block size (in bytes), or 0 if the underlying algorithm is not a block cipher
            byte[] ivByte = new byte[cipher.getBlockSize()];
            //This class specifies an initialization vector (IV). Examples which use
            //IVs are ciphers in feedback mode, e.g., DES in CBC mode and RSA ciphers with OAEP encoding operation.
            IvParameterSpec ivParamsSpec = new IvParameterSpec(ivByte);
            cipher.init(Cipher.DECRYPT_MODE, key, ivParamsSpec);
            original = cipher.doFinal(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return original;
    }

   

    public Account buildAccount(AccountWS accountWS) {
        Account account = new Account();
        account.setActive(accountWS.isActive());
        String en1 = new String(encrypt(userName));
        account.setEncrytedPassword(en1);
        account.setUserName(accountWS.userName);
        account.setUserRole(accountWS.getUserRole());

        return account;
    }

/*    
    
        Décrypter décrypter = new Décrypter();
        byte[] decrypted = décrypter.decrypt(encrypted);
        String en =new String(decrypted);
         System.out.println(en);

*/
    public AccountWS buildAccountws(Account account) {

        AccountWS accountWS = new AccountWS();
        String pass = account.getEncrytedPassword();
        
        byte[] b = pass.getBytes();
        b = decrypt(b);
        String en1 = new String(b);
        
        
        accountWS.setActive(account.isActive());
        accountWS.setPassword(en1);
        accountWS.setUserName(account.getUserName());
        accountWS.setUserRole(account.getUserRole());
        System.out.println(pass);
        return accountWS;
    }
}
