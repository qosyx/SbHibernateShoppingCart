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
    
    public AccountWS(String userName, String password, boolean active, String userRole) {
        this.userName = userName;
        this.password = decrypter(password);
        this.active = active;
        this.userRole = userRole;
    }
    
    public AccountWS() {
    }
    /*
    public static String encrypt(String value) {
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
        String retour = encrypted.toString();
        return retour;
    }
    
    public static String decrypt(String encrypted) {
        byte[] bytes = encrypted.getBytes();
        //String retour = encrypted.toString();
        // return retour;
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
            original = cipher.doFinal(bytes);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String retour = new String(original);
     //   String retour = original.toString();
        return retour;
        //return original;
    }    
    */
    
    public static final String CIPHER_ALGORITHM = "AES";
    public static final String KEY_ALGORITHM = "AES";
    public static final String PASS_HASH_ALGORITHM = "SHA-256";
    public static final String DEFAULT_PASS = "Your Default Security PassPhrase";

    public String encrypt(String data) {
        try {
            Cipher cipher = buildCipher(DEFAULT_PASS, Cipher.ENCRYPT_MODE);
            byte[] dataToSend = data.getBytes(Charsets.UTF_8);
            byte[] encryptedData = cipher.doFinal(dataToSend);
            return Base64.encodeBase64URLSafeString(encryptedData);

        } catch (Exception e) {
           // log.warn(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }



 public String decrypt(String encryptedValue) {
        try {
            Cipher cipher = buildCipher(DEFAULT_PASS, Cipher.DECRYPT_MODE);
            byte[] encryptedData = Base64.decodeBase64(encryptedValue);
            byte[] data = cipher.doFinal(encryptedData);
            return new String(data, Charsets.UTF_8);

        } catch (Exception e) {
           // log.warn(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    private Cipher buildCipher(String password, int mode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        Key key = buildKey(password);
        cipher.init(mode, key);
        return cipher;
    }

    private Key buildKey(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digester = MessageDigest.getInstance(PASS_HASH_ALGORITHM);
        digester.update(String.valueOf(password).getBytes(Charsets.UTF_8.name()));
        byte[] key = digester.digest();
        return new SecretKeySpec(key, KEY_ALGORITHM);
    }
    public Account buildAccount(AccountWS accountWS) {
        Account account = new Account();
        account.setActive(accountWS.isActive());
        account.setEncrytedPassword(encrypt(userName));
        account.setUserName(accountWS.userName);
        account.setUserRole(accountWS.getUserRole());
        
        return account;
    }
    
    public String decrypter(String pass) {
        
        pass = decrypt(pass);
        return pass;
    }

      
    public AccountWS buildAccountws(Account  account){
    
    AccountWS accountWS = new AccountWS();
    String pass=account.getEncrytedPassword();
   pass=encrypt(pass);
    accountWS.setActive(account.isActive());
   // accountWS.setPassword(pass);
    accountWS.setUserName(account.getUserName());
    accountWS.setUserRole(account.getUserRole());
        System.out.println(pass);
    return accountWS;
    }
}
