/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.CRUD;

import java.util.ArrayList;
import java.util.List;
import org.o7planning.SbHibernateShoppingCart.entity.Account;
import org.o7planning.SbHibernateShoppingCart.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author archange
 */
public class AccountCRUD {

    @Autowired
    private AccountRepository accountRepository;

    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public void delete(Account account) {
        accountRepository.delete(account);
    }

    public Account getById(String username) {
        
        return accountRepository.getOne(username);
    }

    public List<Account> getAll() {
       //List<Account> accounts = new ArrayList<Account>();
       //accounts = accountRepository.findAll();
        return accountRepository.findAll();
    }

    public Account update(Account account) {
        return accountRepository.save(account);
    }

}
