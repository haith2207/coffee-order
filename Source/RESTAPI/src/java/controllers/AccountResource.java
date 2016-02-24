/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import blo.AccountsBLO;
import dao.imp.AccountsDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.Accounts;
import utils.Constant;

/**
 * REST Web Service
 *
 * @author Huy Trinh
 */
@Path("account")
public class AccountResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AccountResource
     */
    public AccountResource() {
    }
    private AccountsDAO accountsRepository = new AccountsDAO();

  
    @GET
    @Path("list-all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Accounts> getAll() {
        return accountsRepository.findAll();
    }

    @POST
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Accounts save(
             String username,
             String password,
             String address) {

        Accounts account = new Accounts();
        account.setUsername(username);
        account.setPassword(password);
        account.setRole(Constant.Role.guest);
        account.setStatus(Constant.Status.active);
        account.setDelete(false);
        account.setAddress(address);

        accountsRepository.save(account);

        return account;
    }

    @POST
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")

    public Accounts update(
            @FormParam("username") String username,
            @FormParam("password") String password,
            @FormParam("role") String role,
            @FormParam("status") String status,
            @FormParam("isDelete") boolean isDelete,
            @FormParam("Address") String address) {

        Accounts account = new Accounts();
        account.setUsername(username);
        account.setPassword(password);
        account.setRole(role);
        account.setStatus(status);
        account.setDelete(isDelete);
        account.setAddress(address);

        accountsRepository.update(account);
        return account;
    }

    @POST
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public boolean delete(@FormParam("id")int id) {

        boolean result = false;
        Accounts account = accountsRepository.findOneById(id);

        if (account != null) {
            account.setDelete(true);
            result = accountsRepository.update(account);
        }
        //validate

        return result;
    }

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Accounts login(
            @FormParam("username") String username,
            @FormParam("password") String password) {
        Accounts result = null;
        result = accountsRepository.findOneByUsernameAndPassword(username, password);
        return result;
    }

    @POST
    @Path("search-by-username")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Accounts searchByUsername(@FormParam("username") String username) {
        Accounts result = null;
        result = accountsRepository.findOneByUsername(username);
        return result;

    }

    @POST
    @Path("search-by-id")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Accounts searchByID( @FormParam("id")int id) {
        Accounts result = null;
        result = accountsRepository.findOneById(id);
        return result;
    }
}
