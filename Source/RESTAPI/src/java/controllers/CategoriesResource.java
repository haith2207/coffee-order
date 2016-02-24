/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.imp.CategoriesDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.Categories;
import utils.Constant;

/**
 * REST Web Service
 *
 * @author Huy Trinh
 */
@Path("Categories")
public class CategoriesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CategoriesResource
     */
    public CategoriesResource() {
    }

    private CategoriesDAO cateRepository = new CategoriesDAO();

    @GET
    @Path("list-all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categories> getAll() {
        return cateRepository.findAll();
    }

    @POST
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Categories save(
            @FormParam("name") String name) {

        Categories cate = new Categories();
        cate.setName(name);
        cate.setStatus(Constant.Status.active);
        cate.setDelete(false);
        cateRepository.save(cate);
        return cate;

    }

    @POST
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Categories update(
            @FormParam("name") String name,
            @FormParam("status") String status,
            @FormParam("isDelete") boolean isDelete) {
        Categories cate = new Categories();
        cate.setName(name);
        cate.setStatus(status);
        cate.setDelete(isDelete);
        cateRepository.update(cate);
        return cate;
    }

    @POST
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public boolean delete(@FormParam ("id")int id) {
        boolean result = false;
        Categories cate = cateRepository.findOneByID(id);
        if (cate != null) {
            cate.setDelete(true);
            result = cateRepository.update(cate);
        }
        return result;
    }
    
    @POST
    @Path("search-by-name")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    
    public Categories searchByName (@FormParam("name") String name){
        Categories result = null;
        result = cateRepository.findByName(name);
        return result;
    }
    
    @POST
    @Path("search-by-id")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    
    public Categories searchByName (@FormParam("id") int id){
        Categories result = null;
        result = cateRepository.findOneByID(id);
        return result;
    }

}
