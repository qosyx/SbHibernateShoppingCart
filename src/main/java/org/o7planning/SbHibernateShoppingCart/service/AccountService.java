/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.o7planning.SbHibernateShoppingCart.CRUD.AccountCRUD;
import org.o7planning.SbHibernateShoppingCart.entity.Account;
import org.o7planning.SbHibernateShoppingCart.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author archange
 */
//@Component
@Component
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    public Account create(Account account) throws SQLException {
        accountRepository.save(account);
        return account;
    }
    
    public Account update(Account account) throws SQLException {
        accountRepository.save(account);
        return account;
    }
    
    public List<Account> getAll() throws SQLException {
        List<Account> accounts = new ArrayList<Account>();
        accounts = accountRepository.findAll();
       
        return accounts;
        
    }
    
    public Account getById(String username) throws SQLException {
        
        return accountRepository.getOne(username);
   
    }

    public AccountService() {
    }
    
}
