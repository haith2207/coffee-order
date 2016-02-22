/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blo;

import dao.IAccounts;
import dao.imp.AccountsDAO;
import java.util.List;
import models.Accounts;
import utils.Constant;

/**
 *
 * @author Huy Trinh
 */
public class AccountsBLO {

    private  IAccounts accountService;
//    private static AccountsDAO a = new AccountsDAO();

    public  boolean save(Accounts account) {

        boolean result = false;
        //validate
        result = accountService.save(account);

        return result;
    }

    public boolean update(Accounts account) {
        boolean result = false;
        //validate
        result = accountService.update(account);

        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        Accounts account = accountService.findOneById(id);

        if (account != null) {
            account.setDelete(true);
            result = accountService.update(account);
        }
        //validate

        return result;
    }

    public List<Accounts> findAll() {
        List<Accounts> result = null;
        //validate
        result = accountService.findAll();
        return result;
    }

    public Accounts searchByUsername(String username) {
        Accounts result = null;

        result = accountService.findOneByUsername(username);
        return result;

    }

    public Accounts searchByID(int id) {
        Accounts result = null;
        result = accountService.findOneById(id);
        return result;
    }

    public Accounts login(String username, String password) {
        Accounts result = null;
        result = accountService.findOneByUsernameAndPassword(username, password);
        return result;
    }

}
