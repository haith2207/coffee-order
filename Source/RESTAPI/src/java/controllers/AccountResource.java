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
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.Accounts;

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
private AccountsDAO accountsRepository= new AccountsDAO();
    /**
     * Retrieves representation of an instance of controllers.AccountResource
     * @return an instance of models.Accounts
     */
    @GET
    @Path("list-all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Accounts> getAll() {
   return   accountsRepository.findAll();
    }

    /**
     * PUT method for updating or creating an instance of AccountResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Accounts content) {
    }
}
