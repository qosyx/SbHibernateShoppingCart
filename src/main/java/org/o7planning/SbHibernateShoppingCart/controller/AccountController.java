/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.o7planning.SbHibernateShoppingCart.entity.Account;
import org.o7planning.SbHibernateShoppingCart.helpers.AccountWS;
import org.o7planning.SbHibernateShoppingCart.repository.AccountRepository;
import org.o7planning.SbHibernateShoppingCart.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author archange
 */
@RestController("AccountController")
@RequestMapping("/accounts")
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    HttpServletRequest request;

    /*
    @ApiOperation(value = "Create account", response = Iterable.class)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Account> createAccount(@RequestBody Account account) throws SQLException {
        Account result = accountService.create(account);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

     */
    @ApiOperation(value = "Create account", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list")
        ,
        @ApiResponse(code = 401, message = "You are not authorized to view the resource")
        ,
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
        ,
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Account> createAccountws(@RequestBody AccountWS accountws) throws SQLException {
        Account account = new Account();
        account = accountws.buildAccount(accountws);
        Account result = accountService.create(account);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available products", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list")
        ,
        @ApiResponse(code = 401, message = "You are not authorized to view the resource")
        ,
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
        ,
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findAllAccount() throws Exception {
        HttpStatus httpStatus = null;
      //  List<AccountWS> accountWS = new ArrayList<AccountWS>();
        List<Account> accounts = accountService.getAll();
        for (Account account : accounts) {
          AccountWS accountws = new AccountWS();
        System.out.println(accountws.decrypt(account.getEncrytedPassword()));
            
        }
     
  
        httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(accounts, httpStatus);
    }

    /*
    @ApiOperation(value = "View a list of available products", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list")
        ,
        @ApiResponse(code = 401, message = "You are not authorized to view the resource")
        ,
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
        ,
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AccountWS>> findAllAccount() throws Exception {
        HttpStatus httpStatus = null;
        List<AccountWS> accountWS = new ArrayList<AccountWS>();
        List<Account> accounts = new ArrayList<Account>();
        accounts = accountService.getAll();
        for (Account account : accounts) {

            AccountWS accountWS1 = new AccountWS(account.getUserName(), account.getEncrytedPassword(), account.isActive(), account.getUserRole());
            accountWS1 = accountWS1.buildAccountws(account);
            accountWS.add(accountWS1.buildAccountws(account));
            // System.out.println(accountWS1.getPassword());
        }
        httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(accountWS, httpStatus);
    }*/

 /*     account.setEncrytedPassword("yerima");
                
                accountWS.setUserName("toot");
                System.out.println(accountWS.buildAccount(accountWS));
                accountWS=accountWS.buildAccountws(account);
                 System.out.println(accountWS.getPassword().toString());*/
    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public ResponseEntity<Account> findByUserName(@PathVariable("username") String username) throws Exception {
        Account account = new Account();
        HttpStatus httpStatus = null;
        try {
            account = accountService.getById(username);
            httpStatus = HttpStatus.OK;
        } catch (SQLException ex) {

            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(account, httpStatus);
    }

}
